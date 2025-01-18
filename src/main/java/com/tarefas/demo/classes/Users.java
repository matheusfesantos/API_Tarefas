package com.tarefas.demo.classes;

public class Users{

    private String dono;
    private int tarefasRegistradas;

    public Users(String dono, int i) {
        this.dono = dono;
    }

    public Users(int tarefasRegistradas) {
        this.tarefasRegistradas = tarefasRegistradas;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public int getTarefasRegistradas(){
        if(tarefasRegistradas == 0){
            tarefasRegistradas = 1;
            return tarefasRegistradas;
        }
        else{
            return tarefasRegistradas;
        }
    }
    public void setTarefaRegistradas(int tarefasRegistradas){
        this.tarefasRegistradas = tarefasRegistradas;
    }
}