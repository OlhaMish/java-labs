package com.olechok.model;

import com.olechok.generator.ShapeGenerator;
import com.olechok.shapes.Shape;

import java.util.Arrays;
import java.util.Comparator;

public class ShapeModel {
    private Shape[] shapes;

    public ShapeModel(Shape[] shapes) {
        this.shapes = shapes;
    }

    public double calculateTotalArea() {
        if (shapes == null || shapes.length == 0) {
            return 0.0;
        }

        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.calcArea();
        }
        return totalArea;
    }

    public double calculateTotalAreaByType(Class<? extends Shape> shapeType) {
        if (shapes == null || shapes.length == 0) {
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
        Arrays.sort(shapes, Comparator.comparingDouble(Shape::calcArea));
    }

    public void sortShapesByColor() {
        Arrays.sort(shapes, Comparator.comparing(shape -> shape.shapeColor));
    }

    public Shape[] getShapes() {
        return shapes;
    }

    public void setShapes(int numberOfShapes) {
        shapes = ShapeGenerator.generateRandomShapes(numberOfShapes);
    }
}
