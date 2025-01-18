package com.tarefas.demo.classes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tarefas {

    private String tarefa;
    private String inicio;
    private String prazo;
    private String dono;

    // Construtor
    public Tarefas(String tarefa, String inicio, String prazo, String dono) {
        this.tarefa = tarefa;
        this.inicio = inicio;
        this.prazo = prazo;
        this.dono = dono;
    }

    public String getTarefa() {
        return tarefa;
    }

    public void setTarefa(String tarefa) {
        this.tarefa = tarefa;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getPrazo() {
        return prazo;
    }

    public void setPrazo(String prazo) {
        this.prazo = prazo;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }
}