package com.example.EcoHealth;

public class Customer {
    private int id;
    private String persNo;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String martialStatus;
    private boolean hasChildren;
    private String typeOfLiving;
    private boolean hasMortgage;
    private boolean hasBufferSavings;
    private boolean hasChildSavings;
    private boolean hasInsurance;
    private boolean hasPensionSavings;

    public Customer(int id, String persNo, String password, String firstName, String lastName, String email, String martialStatus, boolean hasChildren, String typeOfLiving, boolean hasMortgage, boolean hasBufferSavings, boolean hasChildSavings, boolean hasInsurance, boolean hasPensionSavings) {
        this.id = id;
        this.persNo = persNo;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.martialStatus = martialStatus;
        this.hasChildren = hasChildren;
        this.typeOfLiving = typeOfLiving;
        this.hasMortgage = hasMortgage;
        this.hasBufferSavings = hasBufferSavings;
        this.hasChildSavings = hasChildSavings;
        this.hasInsurance = hasInsurance;
        this.hasPensionSavings = hasPensionSavings;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMartialStatus() {
        return martialStatus;
    }

    public void setMartialStatus(String martialStatus) {
        this.martialStatus = martialStatus;
    }

    public boolean isHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    public String getTypeOfLiving() {
        return typeOfLiving;
    }

    public void setTypeOfLiving(String typeOfLiving) {
        this.typeOfLiving = typeOfLiving;
    }

    public boolean isHasMortgage() {
        return hasMortgage;
    }

    public void setHasMortgage(boolean hasMortgage) {
        this.hasMortgage = hasMortgage;
    }

    public boolean isHasBufferSavings() {
        return hasBufferSavings;
    }

    public void setHasBufferSavings(boolean hasBufferSavings) {
        this.hasBufferSavings = hasBufferSavings;
    }

    public boolean isHasChildSavings() {
        return hasChildSavings;
    }

    public void setHasChildSavings(boolean hasChildSavings) {
        this.hasChildSavings = hasChildSavings;
    }

    public boolean isHasInsurance() {
        return hasInsurance;
    }

    public void setHasInsurance(boolean hasInsurance) {
        this.hasInsurance = hasInsurance;
    }

    public boolean isHasPensionSavings() {
        return hasPensionSavings;
    }

    public void setHasPensionSavings(boolean hasPensionSavings) {
        this.hasPensionSavings = hasPensionSavings;
    }
//i DB endast en tabell just nu va rtvungen att radera
//lägg till unique i customer tabell på persNo
//spelar ingen roll vilka villkor som ligger i databas (unique, not null etc) då constructor styr hur man kan skapar objekt
// ändra från resultset to prepaerd statment för att skydda lösenord
}


