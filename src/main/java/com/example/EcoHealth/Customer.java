package com.example.EcoHealth;

public class Customer {
    private Integer persNo;
    private String firstName;
    private String lastName;
    private String email;

    public Customer(Integer persNo, String firstName, String lastName, String email) {
        this.persNo = persNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Integer getPersNo() {
        return persNo;
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
