package com.olechok;


public class Main {
    public static void main(String[] args) {

        Shape rectangle = new Rectangle("Red", 5, 10);

        ShapeView view = new ShapeView();
        ShapeController controller = new ShapeController(rectangle, view);
        controller.updateView();

        Shape triangle = new Triangle("Blue", 3, 6);
        ShapeController controller2 = new ShapeController(triangle, view);
        controller2.updateView();

        Shape circle = new Circle("Green", 7);
        ShapeController controller3 = new ShapeController(circle, view);
        controller3.updateView();

    }
}




