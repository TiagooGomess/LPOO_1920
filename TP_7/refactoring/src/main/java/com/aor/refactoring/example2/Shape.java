package com.aor.refactoring.example2;

public abstract class Shape {

    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    public abstract void draw(GraphicFramework graphics);
}
