package com.olechok;
import java.util.Arrays;
import java.util.Comparator;

class ShapeController {
    private Shape[] shapes;
    private ShapeView view;

    public ShapeController(Shape[] shapes, ShapeView view) {
        this.shapes = shapes;
        this.view = view;
    }

    public void displayShapes() {
        view.displayShapeList(shapes);
    }

    public void calculateTotalArea() {
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.calcArea();
        }
        view.displayTotalArea(totalArea);
    }

    public void calculateTotalAreaByType(Class<? extends Shape> shapeType) {
        double totalArea = 0;
        String typeName = shapeType.getSimpleName();

        for (Shape shape : shapes) {
            if (shapeType.isInstance(shape)) {
                totalArea += shape.calcArea();
            }
        }
        view.displayTotalAreaByType(totalArea, typeName);
    }

    public void sortShapesByArea() {
        Arrays.sort(shapes, Comparator.comparingDouble(Shape::calcArea));
    }

    public void sortShapesByColor() {
        Arrays.sort(shapes, Comparator.comparing(Shape::calcArea));
    }
}

