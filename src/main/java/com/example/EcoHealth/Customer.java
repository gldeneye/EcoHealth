package com.example.EcoHealth;

public class Customer {
    private int id;
    private String persNo;
    private String password;
    private String firstName;
    private String lastName;
    private String email;

    //förenklad constructor för att få DB att fungera.
// tänk på att ändra i repots getcustomers metod i "new customer"
    //i DB endast en tabell just nu va rtvungen att radera
    //lägg till unique i customer tabell på persNo
    public Customer(String persNo, String firstName, String lastName) {
        this.persNo = persNo;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getPersNo() {
        return persNo;
    }
}