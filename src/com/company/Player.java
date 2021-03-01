package com.company;
import java.util.Scanner;

public class Player {
    private final String name;

    // Initialize
    public Player(String name){
        // set the player name
        this.name = name;
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

    //askForSize
    public int askForSize() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the board you want between 10x10 - 30x30: ");
        return sc.nextInt();
    }

    //numberOfBombs
    public int numberOfBombs() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of bombs from 10-30: ");
        return sc.nextInt();
    }

    // askForAction
    public String askForAction() {
        Scanner sc = new Scanner(System.in);
        // Display message asking for action
        System.out.println("Enter F to flag or C to clear the coordinates: ");
        // return the input from the console as a string
        return sc.nextLine();
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
        return new int[]{x, y};
    }

    // coordinateIsOnBoard
    public boolean coordinatesAreOnBoard(int[] coordinates) {
        // IF coordinates are outside of the board
        if (coordinates[0] < 1
                || coordinates[0] > 10
                || coordinates[1] < 1
                || coordinates[1] > 10) {
            // print error message
            System.out.println("The coordinates are not on the board.");
            return false;
        }
        return true;
    }

    // getName
    public String getName() {
        return name;
    }

}
