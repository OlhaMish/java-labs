package com.olechok;

import com.olechok.controller.ShapeController;
import com.olechok.model.ShapeModel;
import com.olechok.utils.InputUtils;
import com.olechok.view.ShapeView;

public class ShapeApp {
    public static void main(String[] args) {
        ShapeModel model = new ShapeModel(null);
        ShapeView view = new ShapeView();
        ShapeController controller = new ShapeController(model, view);

        boolean running = true;
        InputUtils inputUtils = new InputUtils();

        while (running) {
            inputUtils.printMenu();

            int choice = inputUtils.getChoice();
            switch (choice) {
                case 1:
                    controller.setShapes(10);
                    System.out.println("Generated new shapes:");
                    controller.displayShapes();
                    break;
                case 2:
                    controller.calculateTotalArea();
                    break;
                case 3:
                    String shapeType = inputUtils.getShapeType();
                    controller.getTotalAreaByType(shapeType);
                    break;
                case 4:
                    System.out.println("\nShapes sorted by Area:");
                    controller.sortShapesByArea();
                    break;
                case 5:
                    System.out.println("\nShapes sorted by Color:");
                    controller.sortShapesByColor();
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        inputUtils.scannerClose();
    }
}

