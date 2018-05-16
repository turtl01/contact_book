package com.contactbook;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DataBase {
    public Connection conn;
    public Statement statmt;

    public DataBase() throws ClassNotFoundException, SQLException{
        conn = null;
        Class.forName("org.sqlite.JDBC");
        this.conn = DriverManager.getConnection("jdbc:sqlite:./db/contact_book.db");
        System.out.println("База подключенна");
        this.select();
    }


    public void select() throws SQLException {
        statmt = this.conn.createStatement();
        statmt.execute("INSERT INTO 'users' ('first_name', 'first_family') VALUES ('Petya', 125453); ");
        System.out.println("user добавлен");
    }
}
