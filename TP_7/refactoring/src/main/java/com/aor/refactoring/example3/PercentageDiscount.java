package com.aor.refactoring.example3;

public class PercentageDiscount implements Discount {
    private double percentage;
    PercentageDiscount(double percentage) {
        this.percentage = percentage;
    }
    public double applyDiscount(double price) {
        return price - price * percentage;
    }
}
