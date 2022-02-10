package com.example.EcoHealth;

public class Customer {
    private int id;
    private String persNo;
    private String password;
    private String firstName;
    private String lastName;
    private String email;

//i DB endast en tabell just nu va rtvungen att radera
//lägg till unique i customer tabell på persNo
    //spelar ingen roll vilka villkor som ligger i databas (unique, not null etc) då constructor styr hur man kan skapar objekt
    // ändra från resultset to prepaerd statment för att skydda lösenord

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