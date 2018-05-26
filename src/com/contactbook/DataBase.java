package com.contactbook;

import java.sql.*;

public class DataBase {
    private final String table_name;
    public Connection conn;
    public Statement statmt;

    public DataBase(String table_name) throws ClassNotFoundException, SQLException{
        conn = null;
        Class.forName("org.sqlite.JDBC");
        this.conn = DriverManager.getConnection("jdbc:sqlite:./db/contact_book.db");
        System.out.println("База подключенна");
        this.table_name = table_name;
    }


    public void select() throws SQLException {
        statmt = this.conn.createStatement();
        statmt.execute("INSERT INTO 'users' ('first_name', 'first_family') VALUES ('Petya', 125453); ");
        System.out.println("user добавлен");
    }

    public void insert(String first_name, String last_name,String email, int phone_number, String data_of_birth) {
        String sql = "INSERT INTO "+table_name+"('first_name', 'first_family', 'email', 'phone_number', 'date_of_birth' ) VALUES(?,?,?,?,?)";

        try (Connection connection = this.conn;
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, first_name);
            pstmt.setString(2, last_name);
            pstmt.setString(3, email);
            pstmt.setInt(4, phone_number);
            pstmt.setString(5, data_of_birth);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(String sql, int id) {
        try (PreparedStatement statement = this.conn.prepareStatement(
                sql)) {
            statement.setObject(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int id, String first_name, String last_name,String email, int phone_number, String data_of_birth) {
        String sql = "UPDATE warehouses "+table_name+"  first_name = ? , " + "last_name = ? " + "email = ? " + "phone_number = ? " + "data_of_birth = ? " + "WHERE id = ?";
        try (Connection connection = this.conn;
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, first_name);
            pstmt.setString(2, last_name);
            pstmt.setString(3, email);
            pstmt.setInt(4, phone_number);
            pstmt.setString(5, data_of_birth);
            pstmt.setInt(6, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
