package com.contactbook;

import java.sql.SQLException;

public class User {
    private final String table_name = "users";
    private String first_name;
    private String last_name;
    private String email;
    private int phone_number;
    private String data_of_birth;
    private int id;

    public User(String first_name, String last_name, String email, int phone_number, String data_of_birth) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone_number = phone_number;
        this.data_of_birth = data_of_birth;


    }
    public User(int id) {
        this.id = id;
    }

    public User(String first_name, String last_name, String email, int phone_number, String data_of_birth, int id) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone_number = phone_number;
        this.data_of_birth = data_of_birth;
        this.id = id;

    }
    public void show(){
        System.out.println(this.first_name + " " + last_name + " " + email + " " + phone_number + " " + data_of_birth);
    }

    public void add() throws SQLException, ClassNotFoundException {
        DataBase db = new DataBase(table_name);
        db.insert(first_name, last_name, email, phone_number, data_of_birth);
    }

    public void delete() throws SQLException, ClassNotFoundException {
        DataBase db = new DataBase(table_name);
        String sql = "DELETE FROM "+table_name+" WHERE id = ?";
        db.delete(sql, id);
    }
    public void update() throws SQLException, ClassNotFoundException {
        DataBase db = new DataBase(table_name);
        db.update(first_name, last_name, email, phone_number, data_of_birth, id );
    }
}
