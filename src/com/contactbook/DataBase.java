package com.contactbook;

import java.sql.*;

public class DataBase {
    public Connection conn;
    public Statement statmt;
    private final String table_name = "users";


    public DataBase() throws ClassNotFoundException, SQLException{
        conn = null;
        Class.forName("org.sqlite.JDBC");
        this.conn = DriverManager.getConnection("jdbc:sqlite:./db/contact_book.db");
        System.out.println("готово");
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
    public void addTable(String table) throws SQLException {
        statmt = conn.createStatement();
        statmt.execute("CREATE TABLE if not exists " + table+ " ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'phone' INT);");

    }
    public void select(String table) throws SQLException {
        String sql = "SELECT * FROM " + table;
        try (Connection connection = this.conn;
             PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs    = pstmt.executeQuery()){
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  " (номер ID)      " +
                        rs.getString("first_name") + " (Имя)        " +
                        rs.getString("first_family")  + " (Фамилия)       " +
                        rs.getString("email")  + " (Email)       " +
                        rs.getString("phone_number")  + " (Номер телефона)      " +
                        rs.getString("date_of_birth") + " (Дата рождения)       ");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void selectid(String table, int id) throws SQLException {
        String sql = "SELECT id FROM " + table;
        try (Connection connection = this.conn;
             PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs  = pstmt.executeQuery()){

                System.out.println(rs.getInt("id") +  " (номер ID)      " +
                        rs.getString("first_name") + " (Имя)        " +
                        rs.getString("first_family")  + " (Фамилия)       " +
                        rs.getString("email")  + " (Email)       " +
                        rs.getString("phone_number")  + " (Номер телефона)      " +
                        rs.getString("date_of_birth") + " (Дата рождения)       ");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void update(String first_name, String last_name,String email, int phone_number, String data_of_birth, int id ) {
        String sql = "UPDATE "+table_name+" SET first_name = ?, first_family = ?, email = ?, phone_number = ?, date_of_birth = ? WHERE id = ?";
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
