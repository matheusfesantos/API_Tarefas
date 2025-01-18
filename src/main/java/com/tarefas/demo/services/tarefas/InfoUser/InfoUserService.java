package com.tarefas.demo.services.tarefas.InfoUser;

import com.tarefas.demo.classes.Tarefas;
import com.tarefas.demo.exeptions.UserNaoExiste;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class InfoUserService {

    public List<Tarefas> infoUser(String dono) {
        List<Tarefas> infoUser = new ArrayList<>();
        String ArquivoTarefas = "src/main/data/tarefas/tarefas.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(ArquivoTarefas))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");

                if (partes.length == 4){

                    String tarefa = partes[0].trim();
                    String inicio = partes[1].trim();
                    String prazo = partes[2].trim();
                    String dono2 = partes[3].trim();

                    if (dono2.equalsIgnoreCase(dono)) {
                        Tarefas tr = new Tarefas(tarefa, inicio, prazo, dono);
                        infoUser.add(tr);
                    }
                }
            }


        } catch (IOException e){
            System.out.println("Err ao ler ao aquivo: " +e.getMessage());
        }

        return infoUser;
    }
}