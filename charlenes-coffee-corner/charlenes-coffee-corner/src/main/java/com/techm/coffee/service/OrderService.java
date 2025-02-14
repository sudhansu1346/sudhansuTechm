package com.techm.coffee.service;

import com.techm.coffee.model.Coffee;
import com.techm.coffee.model.Snack;
import com.techm.coffee.model.OrangeJuice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    public double calculateTotal(List<Object> items, boolean isFifthOrder) {
        double total = 0.0;
        boolean hasBeverage = false, hasSnack = false;
        
        for (Object item : items) {
            if (item instanceof Coffee) {
                total += ((Coffee) item).getPrice();
                hasBeverage = true;
            } else if (item instanceof Snack) {
                total += ((Snack) item).getPrice();
                hasSnack = true;
            } else if (item instanceof OrangeJuice) {
                total += ((OrangeJuice) item).getPrice();
                hasBeverage = true;
            }
        }

        // Discount for every 5th beverage
        if (isFifthOrder && hasBeverage) {
            total -= 3.50; // Assuming the most expensive beverage (large coffee) is free
        }

        // Free extra for beverage + snack combo
        if (hasBeverage && hasSnack) {
            total -= 0.50; // Assuming the most expensive extra is free
        }

        return total;
    }
}
