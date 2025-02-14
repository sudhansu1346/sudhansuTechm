package com.techm.coffee.model;

import lombok.Data;
import java.util.List;

@Data
public class Order {

    private List<String> items;

    @Override
    public String toString() {
        return "Order{" + "items=" + items + '}';
    }
}
