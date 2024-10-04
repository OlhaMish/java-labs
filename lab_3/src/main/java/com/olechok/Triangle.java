package com.olechok;

class Triangle extends Shape {
    private double height;
    private double base;

    public Triangle(String shapeColor, double height, double base) {
        super(shapeColor);
        this.height = height;
        this.base = base;
    }

    @Override
    public double calcArea() {
        return base * height / 2;
    }

    @Override
    public void draw() {
        System.out.print("Drawing '△\n");
    }

    @Override
    public String toString() {
        return super.toString() + "Triangle [height=" + height + ", " +
                "base=" + base + ", " +
                "color=" + shapeColor + ", " +
                "area=" + calcArea() + "]";
    }
}
