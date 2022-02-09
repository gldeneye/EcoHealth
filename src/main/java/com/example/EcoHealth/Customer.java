package com.example.EcoHealth;

public class Customer {
    private int id;
    private int persNo;
    private String password;
    private String firstName;
    private String lastName;
    private String email;

    public Customer(int id, int persNo, String password, String firstName, String lastName, String email) {
        this.id = id;
        this.persNo = persNo;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public int getPersNo() {
        return persNo;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
}
