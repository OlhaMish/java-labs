package com.olechok;

import com.olechok.shapes.Circle;
import com.olechok.shapes.Rectangle;
import com.olechok.shapes.Shape;
import com.olechok.view.ShapeView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShapeViewTest {

    private ShapeView view;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        view = new ShapeView();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void testDisplayShapeList() {
        List<Shape> shapes = Arrays.asList(
                new Circle("Red", 2),
                new Rectangle("Blue", 3, 4)
        );

        view.displayShapeList(shapes);

        String expectedOutput = "Shape info: Circle [radius=2.0, color=Red, area=12.566370614359172]\n"
                + "Shape info: Rectangle [height=4.0, width=3.0, color=Blue, area=12.0]";
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }

    @Test
    void testDisplayTotalArea() {
        view.displayTotalArea(50.0);
        assertEquals("Total Area of All Shapes: 50.0", outputStreamCaptor.toString().trim());
    }

    @Test
    void testDisplayMessage() {
        view.displayMessage("Test message");
        assertEquals("Test message", outputStreamCaptor.toString().trim());
    }
}
