package com.company;
import java.io.File;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        MineSweeper mineSweeper = new MineSweeper();
        mineSweeper.play();
        while (askPlayAgain()) {
            mineSweeper = new MineSweeper();
            mineSweeper.play();
        }
        System.out.println("Bye...");
        System.out.println("******************************************************************************************");
    }

    public static boolean askPlayAgain() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to play again? Enter y (yes) or n (no): ");
        String playAgain = sc.nextLine().trim().toLowerCase();
        while (!playAgain.equals("y") && !playAgain.equals("n")) {
            System.out.println("That's not a valid answer. Do you want to play again?");
            playAgain = sc.nextLine().trim().toLowerCase();
        }
        return playAgain.equals("y");
    }

}
