package com.olechok;

class ShapeController {
    private ShapeModel model;
    private ShapeView view;

    public ShapeController(ShapeModel model, ShapeView view) {
        this.model = model;
        this.view = view;
    }

    public void displayShapes() {
        view.displayShapeList(model.getShapes());
    }

    public void calculateTotalArea() {
        double totalArea = model.calculateTotalArea();
        if (totalArea != 0.0) {
            view.displayTotalArea(totalArea);
        } else {
            view.displayMessage("No shapes to calculate.");
        }
    }

    public void calculateTotalAreaByType(Class<? extends Shape> shapeType) {
        double totalAreaByType = model.calculateTotalAreaByType(shapeType);
        String typeName = shapeType.getSimpleName();
        if (totalAreaByType != 0.0) {
            view.displayTotalAreaByType(totalAreaByType, typeName);
        } else {
            view.displayMessage("No shapes to calculate.");
        }
    }

    public void sortShapesByArea() {
        double totalArea = model.calculateTotalArea();
        if (totalArea != 0.0) {
            model.sortShapesByArea();
            view.displayMessage("Shapes sorted by Area:");
            view.displayShapeList(model.getShapes());
        } else {
            view.displayMessage("No shapes to sort.");
        }
    }

    public void sortShapesByColor() {
        double totalArea = model.calculateTotalArea();
        if (totalArea != 0.0) {
            model.sortShapesByColor();
            view.displayMessage("Shapes sorted by Color:");
            view.displayShapeList(model.getShapes());
        } else {
            view.displayMessage("No shapes to sort.");
        }
    }

    public void setShapes(int numberOfShapes) {
        model.setShapes(numberOfShapes);
    }

    public void getTotalAreaByType(String shapeType) {
        if (shapeType.equalsIgnoreCase("Circle")) {
            calculateTotalAreaByType(Circle.class);
        } else if (shapeType.equalsIgnoreCase("Rectangle")) {
            calculateTotalAreaByType(Rectangle.class);
        } else if (shapeType.equalsIgnoreCase("Triangle")) {
            calculateTotalAreaByType(Triangle.class);
        } else {
            System.out.println("Invalid shape type.");
        }
    }

}
