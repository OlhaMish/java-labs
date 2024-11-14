package com.olechok;

import com.olechok.controller.ShapeController;
import com.olechok.model.ShapeModel;
import com.olechok.utils.FileUtils;
import com.olechok.utils.InputUtils;
import com.olechok.view.ShapeView;
import com.olechok.shapes.Shape;

import java.util.List;

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
                    controller.setShapesWithGenerator(10);
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
                    String saveFilename = inputUtils.getFilePath("Enter filename to save shapes: ");
                    List<Shape> shapesToSave = controller.getShapes();
                    FileUtils.saveShapesToFile(shapesToSave, saveFilename);
                    break;
                case 7:
                    String loadFilename = inputUtils.getFilePath("Enter filename to load shapes: ");
                    List<Shape> loadedShapes = FileUtils.readShapesFromFile(loadFilename);
                    if (loadedShapes != null) {
                        System.out.println("Loaded shapes from file:");
                        loadedShapes.forEach(System.out::println);
                        controller.setShapesFromFile(loadedShapes);
                    }
                    break;
                case 8:
                    System.out.println("Exiting...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        inputUtils.scannerClose();
    }
}
