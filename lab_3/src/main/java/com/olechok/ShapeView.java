package com.olechok;

class ShapeView {
    public void displayShapeList(Shape[] shapes) {
        if (shapes == null || shapes.length == 0) {
            System.out.println("No shapes found.");
        } else {
            for (Shape shape : shapes) {
                System.out.println(shape);
            }
        }
    }

    public void displayTotalArea(double totalArea) {
        System.out.println("Total Area of All Shapes: " + totalArea);
    }

    public void displayTotalAreaByType(double totalArea, String type) {
        if (totalArea == 0) {
            System.out.println("No shapes of type " + type + " found.");
        } else {
            System.out.println("Total Area of " + type + " Shapes: " + totalArea);
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}

