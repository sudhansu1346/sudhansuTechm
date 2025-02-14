package com.techm.coffee.model;

public class Snack {
    private String type; // bacon roll

    public Snack(String type) {
        this.type = type;
    }

    public double getPrice() {
        return "bacon roll".equalsIgnoreCase(type) ? 4.50 : 0.0;
    }

    @Override
    public String toString() {
        return "Snack{type='" + type + "'}";
    }
}
