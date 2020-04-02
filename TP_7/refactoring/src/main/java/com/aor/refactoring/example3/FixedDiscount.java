package com.aor.refactoring.example3;

public class FixedDiscount implements Discount {
    private int discount;
    FixedDiscount(int discount) {
        this.discount = discount;
    }
    public double applyDiscount(double price) {
        return discount > price ? 0 : price - discount;
    }
}
