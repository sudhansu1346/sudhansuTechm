package com.techm.coffee;
import com.techm.coffee.model.Coffee;
import com.techm.coffee.model.Snack;
import com.techm.coffee.model.OrangeJuice;
import com.techm.coffee.service.OrderService;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class OrderServiceTest {

    // 3.50 + 0.30 + 4.50 - 0.50 (free extra)
    @Test
    public void testOrderTotal() {
        OrderService service = new OrderService();
        List<Object> items = List.of(new Coffee("large", true, false, false), new Snack("bacon roll"));
        double total = service.calculateTotal(items, false);
        assertEquals(7.8, total, 0.0001);
    }

    // 5th beverage is free
    @Test
    public void testFifthOrderDiscount() {
        OrderService service = new OrderService();
        List<Object> items = List.of(new Coffee("large", false, false, false));
        double total = service.calculateTotal(items, true);
        assertEquals(0.00, total, 0.0001);
    }

    // 3.00 + 3.95 + 4.50 - 0.50 (free extra)
    @Test
    public void testMultipleItemsWithoutDiscount() {
        OrderService service = new OrderService();
        List<Object> items = List.of(new Coffee("medium", false, false, false), new OrangeJuice(), new Snack("bacon roll"));
        double total = service.calculateTotal(items, false);
        assertEquals(10.95, total, 0.0001);
    }

    // Large coffee is free, only orange juice price remains
    @Test
    public void testMultipleBeveragesWithFifthOrderDiscount() {
        OrderService service = new OrderService();
        List<Object> items = List.of(new Coffee("large", false, false, false), new OrangeJuice());
        double total = service.calculateTotal(items, true);
        assertEquals(3.95, total, 0.0001);
    }

    // 2.50 + 0.30 + 0.50 + 0.90
    @Test
    public void testExtraAddOnsCostCalculation() {
        OrderService service = new OrderService();
        List<Object> items = List.of(new Coffee("small", true, true, true)); // Small coffee with all extras
        double total = service.calculateTotal(items, false);
        assertEquals(4.20, total, 0.0001);
    }

    // No items, no charge
    @Test
    public void testOrderWithNoItems() {
        OrderService service = new OrderService();
        List<Object> items = List.of();
        double total = service.calculateTotal(items, false);
        assertEquals(0.00, total, 0.0001);
    }
}