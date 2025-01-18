/*
package com.tarefas.demo.services.logins;

import com.tarefas.demo.exeptions.LoginInvalido;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class ValidarLoginService {

    private String login;
    private int senha;

    public ValidarLoginService(){

        String logins = "src/main/data/tarefas/logins.txt";

        try (BufferedReader br = new BufferedReader
                (new FileReader(logins))){

            String linha = "";

            while ((linha = br.readLine()) != null) {

                String[] partes = linha.split(";");

                if (partes.length == 2) {
                    String loginBD = partes[0].trim();
                    int senhaBD = Integer.parseInt(partes[1].trim());

                    if (loginBD == login || senhaBD == senha){


                    }
                }
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
 */