package com.contactbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;


public class Main {

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input command");
        Boolean isLive = true;
        //DataBase database = new DataBase();
        User user = new User("dasd", "dasdasd", "dsada", 1231,123);
        user.show();
/*
        while(isLive){
            String inputLine = bufferedReader.readLine();
            switch (inputLine){
                case "adduser":
                    break;
                case "exit":
                    System.out.println("Досвидание епта");
                    isLive = false;
                    break;
                case "user":
                    System.out.println("user");
                    break;
                case "help":
                    String p = "add - добовляет\n";
                    p += "exit - выход из программы\n";
                    p += "user - пользователь\n";
                    System.out.println(p);
                    break;
                default:
                    System.out.println("Please input a command");
                    break;
            }
        }*/
    }

}