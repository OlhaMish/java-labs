package com.olechok.utils;
import com.olechok.shapes.Shape;

import java.io.*;
import java.util.List;

public class FileUtils {

    public static void saveShapesToFile(List<Shape> shapes, String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(shapes);
            System.out.println("Shapes saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving shapes: " + e.getMessage());
        }
    }

    public static List<Shape> readShapesFromFile(String filename) {
        List<Shape> shapes = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            shapes = (List<Shape>) in.readObject();
            System.out.println("Shapes loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading shapes: " + e.getMessage());
        }
        return shapes;
    }
}

