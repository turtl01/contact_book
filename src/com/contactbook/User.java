package com.contactbook;

import java.sql.*;

//задать вопрос что такое  private
public class User {
    private final String table_name = "users";
    private String first_name;
    private String last_name;
    private String email;
    private int phone_number;
    private String data_of_birth;
    private int id;
    private String table;
    private DataBase db = new DataBase();

// задать вопрос нахуй тут канструктор если можно передавать переменные на примую
    public User(String first_name, String last_name, String email, int phone_number, String data_of_birth) throws SQLException, ClassNotFoundException {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone_number = phone_number;
        this.data_of_birth = data_of_birth;


    }
    public User(int id) throws SQLException, ClassNotFoundException {
        this.id = id;
    }

    public User(int id, String first_name, String last_name, String email, int phone_number, String data_of_birth) throws SQLException, ClassNotFoundException {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone_number = phone_number;
        this.data_of_birth = data_of_birth;
        this.id = id;

    }
    public User(String table) throws SQLException, ClassNotFoundException {
        this.table = table;
    }
    public void show(){
        System.out.println(this.first_name + " " + last_name + " " + email + " " + phone_number + " " + data_of_birth);
    }

    public void add() {
        db.insert(this.first_name, this.last_name, this.email, this.phone_number, this.data_of_birth);
    }

    public void delete() {
        String sql = "DELETE FROM "+table_name+" WHERE id = ?";
        db.delete(sql, id);
    }
    public void update() {
        db.update(first_name, last_name, email, phone_number, data_of_birth, id );
    }
    public void addTable() throws SQLException {
        db.addTable(table);
    }
}
