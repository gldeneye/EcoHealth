package com.example.EcoHealth;

public class Customer {
    private int id;
    private String persNo;
    private String password;
    private String firstName;
    private String lastName;
//
    private boolean isSingle;
    private boolean isMarried;
    private boolean isSambo;

    public boolean isSingle() {
        return isSingle;
    }

    public void setSingle(boolean single) {
        isSingle = single;
    }

    public boolean isMarried() {
        return isMarried;
    }

    public void setMarried(boolean married) {
        isMarried = married;
    }

    public boolean isSambo() {
        return isSambo;
    }

    public void setSambo(boolean sambo) {
        isSambo = sambo;
    }

    //
    public Customer(int id, String persNo, String password, String firstName, String lastName, String email, String maritalStatus, boolean hasChildren, String typeOfLiving, boolean hasMortgage, boolean hasBufferSavings, boolean hasChildSavings, boolean hasInsurance, boolean hasPensionSavings) {
        this.id = id;
        this.persNo = persNo;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public Customer(String persNo, String firstName, String lastName) {
    }

    public Customer(String persNo, String password, String firstName, String lastName) {
    }

    public Customer() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPersNo() {
        return persNo;
    }

    public void setPersNo(String persNo) {
        this.persNo = persNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


//i DB endast en tabell just nu va rtvungen att radera
//lägg till unique i customer tabell på persNo
//spelar ingen roll vilka villkor som ligger i databas (unique, not null etc) då constructor styr hur man kan skapar objekt
// ändra från resultset to prepaerd statment för att skydda lösenord
}


