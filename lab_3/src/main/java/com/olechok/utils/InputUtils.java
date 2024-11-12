package com.olechok.utils;

import java.util.Scanner;

public class InputUtils {
    private final Scanner scanner = new Scanner(System.in);

    public void printMenu() {
        System.out.println("\nChoose an option:");
        System.out.println("1. Generate array of shapes");
        System.out.println("2. Calculate total area");
        System.out.println("3. Calculate total area by type");
        System.out.println("4. Sort shapes by area");
        System.out.println("5. Sort shapes by color");
        System.out.println("6. Exit");
    }

    public int getChoice() {
        System.out.print("Enter your choice: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public String getShapeType() {
        System.out.println("Enter shape type (Circle/Rectangle/Triangle): ");
        return scanner.next();
    }

    public void scannerClose() {
        scanner.close();
    }
}
