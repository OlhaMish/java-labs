package com.olechok.shapes;

public class Circle extends Shape {
    private final double radius;

    public Circle(String shapeColor, double radius) {
        super(shapeColor);
        this.radius = radius;
    }

    @Override
    public double calcArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public void draw() {
        System.out.print("Drawing ○\n");
    }

    @Override
    public String toString() {
        return super.toString() + "Circle [radius=" + radius + ", " +
                "color=" + shapeColor + ", " +
                "area=" + calcArea() + "]";
    }
}
