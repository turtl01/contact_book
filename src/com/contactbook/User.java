package com.contactbook;

public class User {
    private String first_name;
    private String last_name;
    private String email;
    private int phone_number;
    private int data_of_birth;

    public User(String first_name, String last_name, String email, int phone_number, int data_of_birth) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone_number = phone_number;
        this.data_of_birth = data_of_birth;

    }


    public void show(){
        System.out.println(this.first_name + " " + last_name + " " + email + " " + phone_number + " " + data_of_birth);
    }
}
