package com.tarefas.demo.services.tarefas.AdicionnarTarefa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class AdicionarTarefa {

    private String tarefa;
    private String inicio;
    private String prazo;
    private String dono;

    public AdicionarTarefa
            (String tarefa, String inicio, String prazo, String dono){

        String ArquivoTarefas = "src/main/data/tarefas/tarefas.txt";

        try(BufferedWriter bw = new BufferedWriter
                (new FileWriter(ArquivoTarefas , true))) {
            bw.newLine();
            bw.newLine();
            bw.write(tarefa + ";");
            bw.write(inicio + ";");
            bw.write(prazo + ";");
            bw.write(dono + ";");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
