package com.example.EcoHealth;

public class Product {
    private String name;
    private String description;
    private String href;
    private int tokens;

    public Product(String name, String description, String href, int tokens) {
        this.name = name;
        this.description = description;
        this.href = href;
        this.tokens=tokens;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public int getTokens() {
        return tokens;
    }

    public void setTokens(int tokens) {
        this.tokens = tokens;
    }
}
