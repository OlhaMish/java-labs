package com.olechok;

import java.lang.reflect.Field;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            // 1. літерал
            String literalString = "London is the capital of Great Britain";
            System.out.println("Before modification (literal): " + literalString);

            modifyString(literalString, "Lutsk is the capital of the World");
            System.out.println("After modification (literal): " + literalString);

            // 2. введення з клавіатури
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a string:");
            String inputString = scanner.nextLine();
            System.out.println("Before modification (input): " + inputString);

            System.out.println("Enter the new value for the string:");
            String newValue = scanner.nextLine();
            modifyString(inputString, newValue);
            System.out.println("After modification (input): " + inputString);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void modifyString(String target, String newValue) throws Exception {
        Class<?> stringClass = String.class;
        Field valueField = stringClass.getDeclaredField("value");
        valueField.setAccessible(true);

        byte[] newByteArray = newValue.getBytes();

        valueField.set(target, newByteArray);
    }
}
