package com.tarefas.demo.services.tarefas.user;

import com.tarefas.demo.classes.Users;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RetornarUsersService {

    public List<Users> retornarUsers() {
        List<Users> listaDeUsuarios = new ArrayList<>();

        Map<String, Integer> usuariosRegistrados = new HashMap<>();

        String ArquivoTarefas = "src/main/data/tarefas/tarefas.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(ArquivoTarefas))) {
            String linha;

            while ((linha = br.readLine()) != null) {

                String[] partes = linha.split(";");

                if (partes.length == 4) {
                    String dono = partes[3].trim();

                    if (usuariosRegistrados.containsKey(dono)) {

                        int contadorDeTarefas = usuariosRegistrados.get(dono) + 1;
                        usuariosRegistrados.put(dono, contadorDeTarefas);

                        for (Users user : listaDeUsuarios) {
                            if (user.getDono().equals(dono)) {
                                user.setTarefaRegistradas(contadorDeTarefas);
                                break;
                            }
                        }

                        System.out.println("Usuário repetido: " + dono +
                                " | Tarefas Registradas: " + contadorDeTarefas);
                    } else {
                        usuariosRegistrados.put(dono, 1);

                        Users ur = new Users(dono, 1);
                        listaDeUsuarios.add(ur);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaDeUsuarios;
    }
}