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
            String first_name, last_name, email, data_of_birth, table;
            switch (inputLine){
                case "add":
                    first_name = bufferedReader.readLine();
                    last_name = bufferedReader.readLine();
                    email = bufferedReader.readLine();
                    phone_number = Integer.parseInt(bufferedReader.readLine());
                    data_of_birth = bufferedReader.readLine();
                    user = new User(0, first_name, last_name, email, phone_number, data_of_birth);
                    user.add();
                    break;
                case "delete":
                    id = Integer.parseInt(bufferedReader.readLine());
                    user = new User(id);
                    user.delete();
                    break;
                case "select":
                    table = bufferedReader.readLine();
                    DataBase bd = new DataBase();
                    bd.select(table);
                    break;
                case "update":
                    System.out.println("Введите id");
                    id = Integer.parseInt(bufferedReader.readLine());
                    System.out.println("Введите имя");
                    first_name = bufferedReader.readLine();
                    System.out.println("Введите фамилию");
                    last_name = bufferedReader.readLine();
                    System.out.println("Введите email");
                    email = bufferedReader.readLine();
                    System.out.println("Введите номер телефона");
                    phone_number = Integer.parseInt(bufferedReader.readLine());
                    System.out.println("Введите дату рождения");
                    data_of_birth = bufferedReader.readLine();
                    user = new User(id, first_name, last_name, email, phone_number, data_of_birth);
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
                case "add table":
                    table = bufferedReader.readLine();
                    user = new User(table);
                    user.addTable();
                default:
                    System.out.println("Please input a command");
                    break;
            }
        }
    }

}