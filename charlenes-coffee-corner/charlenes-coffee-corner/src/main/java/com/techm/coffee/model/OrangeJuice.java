package com.techm.coffee.model;

import lombok.Getter;

@Getter
public class OrangeJuice {
    private final double price = 3.95;

    @Override
    public String toString() {
        return "OrangeJuice{price=" + price + '}';
    }
}
