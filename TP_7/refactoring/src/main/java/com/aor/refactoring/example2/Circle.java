package com.aor.refactoring.example2;

public class Circle extends Shape {
    private double radius;
    Circle(double x, double y, double radius) {
        super.setX(x);
        super.setY(y);
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public void draw(GraphicFramework graphics) {
        graphics.drawCircle(super.getX(), super.getY(), radius);
    }
}
