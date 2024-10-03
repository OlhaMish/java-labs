package com.olechok;

public class ShapeController {
    private Shape model;
    private ShapeView view;

    public ShapeController(Shape shape, ShapeView view) {
        this.model = shape;
        this.view = view;
    }

    public void updateView() {
        view.displayShapeType(model.getClass().getSimpleName());
        view.displayArea(model.calcArea());
    }
}
