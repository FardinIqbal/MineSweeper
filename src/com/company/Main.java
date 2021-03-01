package com.company;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        int[]
        Board board = new Board(10, 40);
        board.render();
//        System.out.println(board.isEdgeCell(new int[] {5, 5}));
        System.out.println(Arrays.toString(board.addCoordinates(new int[]{1, 1}, new int[]{2, 2})));
    }
}
