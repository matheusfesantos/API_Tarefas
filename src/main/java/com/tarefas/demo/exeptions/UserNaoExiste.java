package com.tarefas.demo.exeptions;

public class UserNaoExiste extends RuntimeException {
    public UserNaoExiste(String message){
        super(message);
    }
}
