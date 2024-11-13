package com.olechok.model;

import com.olechok.generator.ShapeGenerator;
import com.olechok.shapes.Shape;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ShapeModel implements Serializable {
    private List<Shape> shapes;

    public ShapeModel(List<Shape> shapes) {
        this.shapes = shapes;
    }

    public double calculateTotalArea() {
        if (shapes == null || shapes.isEmpty()) {
            return 0.0;
        }

        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.calcArea();
        }
        return totalArea;
    }

    public double calculateTotalAreaByType(Class<? extends Shape> shapeType) {
        if (shapes == null || shapes.isEmpty()) {
            return 0.0;
        }
        double totalArea = 0;
        for (Shape shape : shapes) {
            if (shapeType.isInstance(shape)) {
                totalArea += shape.calcArea();
            }
        }
        return totalArea;
    }

    public void sortShapesByArea() {
        shapes.sort(Comparator.comparingDouble(Shape::calcArea));
    }

    public void sortShapesByColor() {
        shapes.sort(Comparator.comparing(shape -> shape.shapeColor));
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    public void setShapes(int numberOfShapes) {
        shapes = ShapeGenerator.generateRandomShapes(numberOfShapes);
    }
}
