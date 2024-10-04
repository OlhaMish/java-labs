package com.olechok;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

class ShapeControllerTest {

    private ShapeModel model;
    private ShapeController controller;
    private ShapeView view;
    private Shape[] shapes;

    @BeforeEach
    void setUp() {
        shapes = new Shape[]{
                new Circle("Red", 3.0),
                new Rectangle("Blue", 4.0, 5.0),
                new Triangle("Green", 4.0, 6.0)
        };
        model = new ShapeModel(shapes);
        view = new ShapeView();
        controller = new ShapeController(model, view);
    }

    @Test
    void testCalculateTotalArea() {
        controller.calculateTotalArea();
        double expectedTotalArea = Math.PI * 9 + 20 + 12;
        assertEquals(expectedTotalArea, Arrays.stream(shapes).mapToDouble(Shape::calcArea).sum(), 0.0001);
    }

    @Test
    void testCalculateTotalAreaByType() {
        controller.calculateTotalAreaByType(Circle.class);
        double expectedCircleArea = Math.PI * 9;  // Circle with radius 3
        assertEquals(expectedCircleArea, Arrays.stream(shapes)
                .filter(shape -> shape instanceof Circle)
                .mapToDouble(Shape::calcArea).sum(), 0.0001);
    }

    @Test
    void testSortShapesByArea() {
        controller.sortShapesByArea();
        assertTrue(shapes[0].calcArea() <= shapes[1].calcArea() &&
                            shapes[1].calcArea() <= shapes[2].calcArea());
    }

    @Test
    void testSortShapesByColor() {
        controller.sortShapesByColor();
        assertTrue(shapes[0].shapeColor.compareTo(shapes[1].shapeColor) <= 0
                && shapes[1].shapeColor.compareTo(shapes[2].shapeColor) <= 0);
    }
}
