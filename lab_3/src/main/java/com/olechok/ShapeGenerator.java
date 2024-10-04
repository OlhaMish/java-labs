package com.olechok;
import java.util.Random;


public class ShapeGenerator {
    private static final Random random = new Random();
    private static final String[] colors = {"Red", "Green", "Blue", "Yellow", "Purple"};

    public static Shape[] generateRandomShapes(int numberOfShapes) {
        Shape[] shapes = new Shape[numberOfShapes];

        for (int i = 0; i < numberOfShapes; i++) {
            int shapeType = random.nextInt(3);
            String color = colors[random.nextInt(colors.length)];

            switch (shapeType) {
                case 0:
                    double radius = 1 + random.nextDouble() * 9;
                    shapes[i] = new Circle(color, radius);
                    break;
                case 1:
                    double width = 1 + random.nextDouble() * 9;
                    double height = 1 + random.nextDouble() * 9;
                    shapes[i] = new Rectangle(color, width, height);
                    break;
                case 2:
                    double base = 1 + random.nextDouble() * 9;
                    double triHeight = 1 + random.nextDouble() * 9;
                    shapes[i] = new Triangle(color, triHeight, base);
                    break;
            }
        }
        return shapes;
    }
}