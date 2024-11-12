package com.olechok.shapes;

import com.olechok.drawable.Drawable;

public abstract class Shape implements Drawable {
    public String shapeColor;

    public Shape(String shapeColor) {
        this.shapeColor = shapeColor;
    }

    public abstract double calcArea();

    public String toString() {
        return "Shape info: ";
    }
}
