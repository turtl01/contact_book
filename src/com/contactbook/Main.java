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

        while(isLive){
            User user = null;
            String inputLine = bufferedReader.readLine();
            switch (inputLine){
                case "add":
                    String first_name = bufferedReader.readLine();
                    String last_name = bufferedReader.readLine();
                    String email = bufferedReader.readLine();
                    int phone_number = Integer.parseInt(bufferedReader.readLine());
                    String data_of_birth = bufferedReader.readLine();
                    user = new User(first_name, last_name, email, phone_number, data_of_birth);
                    user.add();
                    break;
                case "delete":
                    int id = Integer.parseInt(bufferedReader.readLine());
                    user = new User(id);
                    user.delete();
                case "update":
                    int id = Integer.parseInt(bufferedReader.readLine());
                    String first_name = bufferedReader.readLine();
                    String last_name = bufferedReader.readLine();
                    String email = bufferedReader.readLine();
                    int phone_number = Integer.parseInt(bufferedReader.readLine());
                    String data_of_birth = bufferedReader.readLine();
                    user = new User(id, first_name, last_name, email, phone_number, data_of_birth);
                    user.update();
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
        }
    }

}