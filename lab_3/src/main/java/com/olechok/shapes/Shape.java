package com.olechok.shapes;
import com.olechok.drawable.Drawable;

import java.io.Serializable;

public abstract class Shape implements Drawable, Serializable {
    public String shapeColor;

    public Shape(String shapeColor) {
        this.shapeColor = shapeColor;
    }

    public abstract double calcArea();

    public String toString() {
        return "Shape info: ";
    }
}
