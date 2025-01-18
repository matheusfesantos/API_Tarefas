package com.tarefas.demo.services.tarefas.retornar;

import com.tarefas.demo.classes.Tarefas;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class RetornarTarefasService {

    public List<Tarefas> retornarTarefas() {
        List<Tarefas> listaTarefas = new ArrayList<>();

        String ArquivoTarefas = "src/main/data/tarefas/tarefas.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(ArquivoTarefas))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 4) {
                    String tarefa = partes[0].trim();
                    String inicio = partes[1].trim();
                    String prazo = partes[2].trim();
                    String dono = partes[3].trim();

                    Tarefas tr = new Tarefas(tarefa, inicio, prazo, dono);
                    listaTarefas.add(tr);

                } else {
                    System.out.println("Erro ao retornar tarefas: formato inválido na linha -> " + linha);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaTarefas;
    }
}