package com.tarefas.demo.exeptions;

import com.tarefas.demo.classes.Tarefas;

public class VariaveisNulas extends RuntimeException {
    public VariaveisNulas (String mensagem){
        super("Suas variáveis são nulas");
    }
}
