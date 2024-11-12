package com.olechok.shapes;

public class Rectangle extends Shape {
    private final double width;
    private final double height;

    public Rectangle(String shapeColor, double width, double height) {
        super(shapeColor);
        this.width = width;
        this.height = height;
    }

    @Override
    public double calcArea() {
        return width * height;
    }

    @Override
    public void draw() {
        if (width > height) {
            System.out.print("Drawing ▭\n");
        } else System.out.print("Drawing ▯\n");
    }

    @Override
    public String toString() {
        return super.toString() + "Rectangle [height=" + height + ", " +
                "width=" + width + ", " +
                "color=" + shapeColor + ", " +
                "area=" + calcArea() + "]";
    }
}
