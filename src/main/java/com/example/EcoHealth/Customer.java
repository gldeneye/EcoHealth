package com.example.EcoHealth;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Customer {
    private int id;
    private String persNo;
    private String password;
    private String firstName;
    private String lastName;
    private String email;

    public Customer(String persNo, String password, String firstName, String lastName) {
        this.persNo = persNo;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Customer(String persNo, String firstName, String lastName) {
        this.persNo = persNo;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

}