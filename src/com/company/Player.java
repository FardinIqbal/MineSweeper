package com.company;

import java.util.Scanner;

public class Player {
    public int boardSize;

    // getCoordinates
    public int[] getCoordinates() {
        // askForCoordinates
        int[] coordinates = askForCoordinates();
        // loop until the inputted coordinates are valid
        while (!coordinatesAreOnBoard(coordinates, this.boardSize)) {
            // askForCoordinates
            coordinates = askForCoordinates();
        }
        // return valid coordinates
        return coordinates;
    }

    // askForCoordinates
    public int[] askForCoordinates() {
        Scanner sc = new Scanner(System.in);
        // Display message asking for x-coordinate
        System.out.println("Enter the x-coordinate: ");
        int x = sc.nextInt();
        // Display message asking for y-coordinate
        System.out.println("Enter the y-coordinate: ");
        int y = sc.nextInt();
        // return the input from the console in an array
        return new int[]{y - 1, x - 1};
    }

    //askForSize
    public int askForSize() {
        System.out.println("Enter the size of the board you want between 10 (10x10) - 30 (30x30): ");// Initial prompt for input
        int size = askForInteger();
        // And now you can use the input variable.
        while (size < 10 || size > 30) {
            System.out.println("The number you entered is out of range. Enter the size from 10-30: ");
            size = askForInteger();
        }
        return size;
    }

    private int askForInteger() {
        Scanner sc = new Scanner(System.in);// Initial prompt for input
        // Repeat until next item is an integer
        while (!sc.hasNextInt()) {
            sc.next(); // Read and discard offending non-int input
            System.out.print("Please enter an integer: "); // Re-prompt
        }
        return sc.nextInt();
    }

    //numberOfMines
    public int askForNumberOfMines() {
        System.out.println("Enter the number of bombs from 10-30: ");
        int mines = askForInteger();
        while (mines < 10 || mines > 30) {
            System.out.println("The number you entered is out of range. Enter the number of mines from 10-30: ");
            mines = askForInteger();
        }
        return mines;
    }

    // askForAction
    public String askForAction() {
        Scanner sc = new Scanner(System.in);
        // Display message asking for action
        System.out.println("Enter F to flag or C to clear the coordinates: ");
        String input = sc.nextLine().trim().toLowerCase();
        while (!input.equals("f") && !input.equals("c")) {
            System.out.println("That is not an option. Enter F to flag or C to clear the coordinates: ");
            input = sc.nextLine().trim().toLowerCase();
        }
        return input;
    }

    // coordinateIsOnBoard
    public boolean coordinatesAreOnBoard(int[] coordinates, int size) {
        // IF coordinates are outside of the board
        if (coordinates[0] < 0
                || coordinates[0] >= size
                || coordinates[1] < 0
                || coordinates[1] >= size) {
            // print error message
            System.out.println("The coordinates are out of bounds.");
            return false;
        }
        return true;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }
}
