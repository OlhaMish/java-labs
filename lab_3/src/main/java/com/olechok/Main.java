package com.olechok;


public class Main {
    public static void main(String[] args) {
        ShapeGenerator shapeGenerator = new ShapeGenerator();
        Shape[] shapes = shapeGenerator.generateRandomShapes(10);

        ShapeView view = new ShapeView();
        ShapeController controller = new ShapeController(shapes, view);

        System.out.println("Initial Shapes:");
        controller.displayShapes();

        controller.calculateTotalArea();

        controller.calculateTotalAreaByType(Circle.class);

        System.out.println("\nShapes sorted by Area:");
        controller.sortShapesByArea();
        controller.displayShapes();

        System.out.println("\nShapes sorted by Color:");
        controller.sortShapesByColor();
        controller.displayShapes();
    }
}
