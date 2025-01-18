package com.tarefas.demo.controller;

import com.tarefas.demo.classes.Tarefas;
import com.tarefas.demo.classes.UserToString;
import com.tarefas.demo.classes.Users;
import com.tarefas.demo.exeptions.VariaveisNulas;
import com.tarefas.demo.services.tarefas.AdicionnarTarefa.AdicionarTarefa;
import com.tarefas.demo.services.tarefas.InfoUser.InfoUserService;
import com.tarefas.demo.services.tarefas.retornar.RetornarTarefasService;
import com.tarefas.demo.services.tarefas.user.RetornarUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tarefas")
public class TarefasController {

    @Autowired
    private final RetornarTarefasService retornarTarefasService;
    private final RetornarUsersService retornarUsersService;
    private final InfoUserService infoUserService;

    public TarefasController(RetornarTarefasService retornarTarefasService,
                             RetornarUsersService retornarUsersService,
                             InfoUserService infoUserService) {

        this.retornarTarefasService = retornarTarefasService;
        this.retornarUsersService = retornarUsersService;
        this.infoUserService = infoUserService;
    }

    @GetMapping("/todas")
    public List<Tarefas> listarTarefas() {
        return retornarTarefasService.retornarTarefas();
    }

    @GetMapping("/users")
    public List<Users> listarUsersDaTarefas() {
        return retornarUsersService.retornarUsers();
    }

    @PostMapping("/adicionar")
    public AdicionarTarefa adicionarTarefa(@RequestBody Tarefas tarefas) {

        if (tarefas == null) {
            String message = "Suas variáveis são nulas";
            throw new VariaveisNulas(message);
        }
        else{
            String tarefa = tarefas.getTarefa();
            String inicio = tarefas.getInicio();
            String prazo = tarefas.getPrazo();
            String dono = tarefas.getDono();

            AdicionarTarefa af = new AdicionarTarefa
                    (tarefa, inicio, prazo, dono);

            return null;
        }
    }

    @PostMapping("/username")
    public List<Tarefas> listarUser(@RequestBody UserToString userToString) {

        String dono = userToString.getDono();

        if (dono == null){
            String message = "O parâmetro 'dono' está nulo ou vazio";
            throw new VariaveisNulas(message);
        }

        return infoUserService.infoUser(dono);
    }
}