package com.olechok.view;

import com.olechok.shapes.Shape;
import java.util.List;

public class ShapeView {

    public void displayShapeList(List<Shape> shapes) {
        if (shapes == null || shapes.isEmpty()) {
            System.out.println("No shapes found.");
        } else {
            for (Shape shape : shapes) {
                System.out.println(shape);
            }
        }
    }

    // Display the total area of all shapes
    public void displayTotalArea(double totalArea) {
        System.out.println("Total Area of All Shapes: " + totalArea);
    }

    // Display the total area of shapes of a specific type
    public void displayTotalAreaByType(double totalArea, String type) {
        if (totalArea == 0) {
            System.out.println("No shapes of type " + type + " found.");
        } else {
            System.out.println("Total Area of " + type + " Shapes: " + totalArea);
        }
    }

    // Display a custom message
    public void displayMessage(String message) {
        System.out.println(message);
    }
}
