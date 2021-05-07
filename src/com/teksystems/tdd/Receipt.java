package com.teksystems.tdd;

public class Receipt {
    private final Order order;

    private Receipt(Order order) {
        this.order = order;
    }

    public static Receipt getInstance(Order order) {
        return new Receipt(order);
    }

    public Iterable<? extends Item> getItems() {
        return order.getItems();
    }
}
