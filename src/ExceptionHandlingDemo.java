// Summary:
// This file demonstrates how to handle both checked and unchecked exceptions in Java.
// Each example simulates a specific exception, explains the cause, and shows how to handle it using try-catch blocks.
// Proper comments are included for clarity.

import java.io.*;
import java.sql.*;

public class ExceptionHandlingDemo {

    // Checked Exceptions

    public static void simulateIOException() {
        try {
            // Attempting to read a non-existent file
            BufferedReader reader = new BufferedReader(new FileReader("nonexistent.txt"));
            reader.readLine();
        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
        }
    }

    public static void simulateFileNotFoundException() {
        try {
            // Attempting to open a non-existent file
            FileInputStream file = new FileInputStream("nonexistent.txt");
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException occurred: " + e.getMessage());
        }
    }

    public static void simulateEOFException() {
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream("test.txt"))) {
            while (true) {
                dataInputStream.readUTF(); // Reading beyond the file content
            }
        } catch (EOFException e) {
            System.out.println("EOFException occurred: End of file reached.");
        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
        }
    }

    public static void simulateSQLException() {
        try {
            // Attempting to connect to a non-existent database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nonexistentdb", "user", "password");
        } catch (SQLException e) {
            System.out.println("SQLException occurred: " + e.getMessage());
        }
    }

    public static void simulateClassNotFoundException() {
        try {
            // Attempting to load a non-existent class
            Class.forName("com.example.NonExistentClass");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException occurred: " + e.getMessage());
        }
    }

    // Unchecked Exceptions

    public static void simulateArithmeticException() {
        try {
            int result = 10 / 0; // Division by zero
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException occurred: " + e.getMessage());
        }
    }

    public static void simulateNullPointerException() {
        try {
            String str = null;
            System.out.println(str.length()); // Accessing a null reference
        } catch (NullPointerException e) {
            System.out.println("NullPointerException occurred: " + e.getMessage());
        }
    }

    public static void simulateArrayIndexOutOfBoundsException() {
        try {
            int[] array = {1, 2, 3};
            System.out.println(array[5]); // Accessing an invalid index
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException occurred: " + e.getMessage());
        }
    }

    public static void simulateClassCastException() {
        try {
            Object obj = "String";
            Integer num = (Integer) obj; // Invalid type cast
        } catch (ClassCastException e) {
            System.out.println("ClassCastException occurred: " + e.getMessage());
        }
    }

    public static void simulateIllegalArgumentException() {
        try {
            Thread.sleep(-1000); // Invalid argument
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException occurred: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("InterruptedException occurred: " + e.getMessage());
        }
    }

    public static void simulateNumberFormatException() {
        try {
            int number = Integer.parseInt("invalid"); // Invalid string to number conversion
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException occurred: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Checked Exceptions
        simulateIOException();
        simulateFileNotFoundException();
        simulateEOFException();
        simulateSQLException();
        simulateClassNotFoundException();

        // Unchecked Exceptions
        simulateArithmeticException();
        simulateNullPointerException();
        simulateArrayIndexOutOfBoundsException();
        simulateClassCastException();
        simulateIllegalArgumentException();
        simulateNumberFormatException();
    }
}

