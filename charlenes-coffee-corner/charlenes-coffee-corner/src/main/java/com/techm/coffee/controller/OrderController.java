package com.techm.coffee.controller;

import com.techm.coffee.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private int orderCount = 0;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/place")
    public String placeOrder(@RequestBody List<Object> items) {
        orderCount++;
        boolean isFifthOrder = (orderCount % 5 == 0);
        double total = orderService.calculateTotal(items, isFifthOrder);
        return "Total price: " + total + " CHF";
    }
}
