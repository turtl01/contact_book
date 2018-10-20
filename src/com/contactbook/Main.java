package com.contactbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;


public class Main {

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input command");
        Boolean isLive =  true;

        while(isLive){
            User user = null;
            String inputLine = bufferedReader.readLine();
            int id, phone_number;
            String first_name, last_name, email, data_of_birth;
            switch (inputLine){
                case "add":
                    first_name = bufferedReader.readLine();
                    last_name = bufferedReader.readLine();
                    email = bufferedReader.readLine();
                    phone_number = Integer.parseInt(bufferedReader.readLine());
                    data_of_birth = bufferedReader.readLine();
                    user = new User(first_name, last_name, email, phone_number, data_of_birth);
                    user.add();
                    break;
                case "delete":
                    id = Integer.parseInt(bufferedReader.readLine());
                    user = new User(id);
                    user.delete();
                    break;
                case "update":
                    first_name = bufferedReader.readLine();
                    last_name = bufferedReader.readLine();
                    email = bufferedReader.readLine();
                    phone_number = Integer.parseInt(bufferedReader.readLine());
                    data_of_birth = bufferedReader.readLine();
                    id = Integer.parseInt(bufferedReader.readLine());
                    user = new User(first_name, last_name, email, phone_number, data_of_birth, id);
                    user.update();
                    break;
                case "exit":
                    System.out.println("Досвидание епта");
                    isLive = false;
                    break;
                case "user":
                    String sql = "SELECT * FROM user ";
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