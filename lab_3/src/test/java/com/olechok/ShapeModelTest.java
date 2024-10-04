package com.olechok;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShapeModelTest {

    @Test
    void testCircleArea() {
        Circle circle = new Circle("Red", 3.0);
        assertEquals(Math.PI * 9, circle.calcArea(), 0.0001,
                "Circle area should be π * r^2");
    }

    @Test
    void testRectangleArea() {
        Rectangle rectangle = new Rectangle("Blue", 4.0, 5.0);
        assertEquals(20.0, rectangle.calcArea(), 0.0001,
                "Rectangle area should be width * height");
    }

    @Test
    void testTriangleArea() {
        Triangle triangle = new Triangle("Green", 4.0, 6.0);
        assertEquals(12.0, triangle.calcArea(), 0.0001,
                "Triangle area should be 0.5 * base * height");
    }
}

