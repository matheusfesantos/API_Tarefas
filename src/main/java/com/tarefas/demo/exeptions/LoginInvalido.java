package com.tarefas.demo.exeptions;

public class LoginInvalido extends RuntimeException {
    public LoginInvalido(String message) {
        super(message);
    }
}
