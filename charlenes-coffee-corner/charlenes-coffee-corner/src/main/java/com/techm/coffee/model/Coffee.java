package com.techm.coffee.model;


public class Coffee {
    private String size; // small, medium, large
    private boolean extraMilk;
    private boolean foamedMilk;
    private boolean specialRoast;

    public Coffee(String size, boolean extraMilk, boolean foamedMilk, boolean specialRoast) {
        this.size = size;
        this.extraMilk = extraMilk;
        this.foamedMilk = foamedMilk;
        this.specialRoast = specialRoast;
    }

    public double getPrice() {
        double price = switch (size.toLowerCase()) {
            case "small" -> 2.50;
            case "medium" -> 3.00;
            case "large" -> 3.50;
            default -> 0.0;
        };
        if (extraMilk) price += 0.30;
        if (foamedMilk) price += 0.50;
        if (specialRoast) price += 0.90;
        return price;
    }

    @Override
    public String toString() {
        return "Coffee{size='" + size + "', extraMilk=" + extraMilk + ", foamedMilk=" + foamedMilk + ", specialRoast=" + specialRoast + '}';
    }
}
