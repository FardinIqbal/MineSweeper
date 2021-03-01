package com.company;
import java.util.Scanner;

public class Player {
    // Initialize
    public Player(){
    }

    // getCoordinates
    public int[] getCoordinates() {
        // askForCoordinates
        int[] coordinates = askForCoordinates();
        // loop until the inputted coordinates are valid
        while (!coordinatesAreOnBoard(coordinates)) {
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
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the board you want between 10 (10x10) - 30 (30x30): ");
        int size = sc.nextInt();
        while (size < 10 || size > 30) {
            System.out.println("The number you entered is out of range. Enter the size from 10-30: ");
            size = sc.nextInt();
        }
        return size;
    }


    //numberOfMines
    public int askForNumberOfMines() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of bombs from 10-30: ");
        int mines = sc.nextInt();
        System.out.println(mines < 10 || mines > 30);
        while (mines < 10 || mines > 30) {
            System.out.println("The number you entered is out of range. Enter the number of mines from 10-30: ");
            mines = sc.nextInt();
        }
        return mines;
    }

    // askForAction
    public String askForAction() {
        Scanner sc = new Scanner(System.in);
        // Display message asking for action
        System.out.println("Enter F to flag or C to clear the coordinates: ");
        // return the input from the console as a string
        return sc.nextLine();
    }

    // coordinateIsOnBoard
    public boolean coordinatesAreOnBoard(int[] coordinates) {
        // IF coordinates are outside of the board
        if (coordinates[0] < 0
                || coordinates[0] > 10
                || coordinates[1] < 0
                || coordinates[1] > 10) {
            // print error message
            System.out.println("The coordinates");
            return false;
        }
        return true;
    }

}
