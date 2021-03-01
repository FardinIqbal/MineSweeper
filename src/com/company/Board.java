package com.company;

import java.util.Arrays;

public class Board {
    private final int size;
    private final Cell[][] board;
    private final int numberOfMines;
    private final int[][] surroundingCellsCoordinates = new int[][]{
            {-1, 1},  {0, 1},  {1, 1},
            {-1, 0},           {1, 0},
            {-1, -1},  {0, -1},{1, -1}
    };

    // initialize board
    public Board(int size, int numberOfMines) {
        // create blank 2D array
        this.board = new Cell[size][size];
        this.size = size;
        this.numberOfMines = numberOfMines;
        createBoard();
    }

    public void createBoard() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                this.board[row][col] = new Cell(" ");
            }
        }
        insertMines();
        fillEmptyCells();
    }

    public void insertMines() {
        int[] coordinate = randomCoordinate();
        for(int mines = 0; mines < numberOfMines; mines++) {
            while (board[coordinate[0]][coordinate[1]].getValue().equals("*")) {
                coordinate = randomCoordinate();
            }
            board[coordinate[0]][coordinate[1]].setValue("*");
            coordinate = randomCoordinate();
        }
    }

    public void fillEmptyCells() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if(!board[row][col].getValue().equals("*")) {
                    board[row][col].setValue(numberOfSurroundingMines(new int[]{row, col}));
                }
            }
        }
    }

    public String numberOfSurroundingMines(int[] currentCoordinates) {
        int mines = 0;
        for(int[] coordinates : getSurroundingCellCoordinates(currentCoordinates)) {
            if(board[coordinates[0]][coordinates[1]].getValue().equals("*")) {
                mines++;
            }
        }
        return mines + "";
    }

    public int[][] getSurroundingCellCoordinates(int[] currentCoordinates) {
        int numberOfSurroundingCells = numberOfSurroundingCells(currentCoordinates);
        int[][] surroundingCellCoordinates = new int[numberOfSurroundingCells][2];
        int i = 0;
        for (int[] coordinates : this.surroundingCellsCoordinates) {
            int[] surroundingCoordinate = addCoordinates(coordinates, currentCoordinates);
            if(coordinatesAreOnBoard(surroundingCoordinate)){
                surroundingCellCoordinates[i] = surroundingCoordinate;
                i++;
            }
        }
        return surroundingCellCoordinates;
    }

    public boolean coordinatesAreOnBoard(int[] coordinates) {
        // IF coordinates are outside of the board
        return coordinates[0] >= 0
                && coordinates[0] < this.size
                && coordinates[1] >= 0
                && coordinates[1] < this.size;
    }

    public int numberOfSurroundingCells(int[] coordinates) {
        if (isCornerCell(coordinates)) {
            return 3;
        } else if (isEdgeCell(coordinates)){
            return 5;
        } else {
            return 8;
        }
    }

    public boolean isCornerCell(int[] coordinates) {
        int row = coordinates[0];
        int col = coordinates[1];

        return (row == 0 && col == 0)
                || (row == 0 && col == size - 1)
                || (col == 0 && row == size - 1)
                || (col == size -1 && row == size - 1);
    }

    public boolean isEdgeCell(int[] coordinates) {
        int row = coordinates[0];
        int col = coordinates[1];
        return (row == 0 && col > 0 && col < size - 1)
                || (row == size - 1 && col < size - 1 && col > 0)
                || (col == 0 && row > 0 && row < size - 1)
                || (col == size - 1 && row > 0 && row < size - 1);
    }

    public int[] addCoordinates(int[] coordinate1, int[] coordinate2) {
        return new int[] {coordinate1[0] + coordinate2[0], coordinate1[1] + coordinate2[1]};
    }

    public int[] randomCoordinate () {
        return new int[] {(int) (Math.random() * size), (int) (Math.random() * size)};
    }

    // render
    public void render() {
        // loop through the 2D array
        openAllCells();
        renderColumnNumbers();
        for (int row = 0; row < size; row++) {
            if (row >= 9) {
                System.out.print(row + 1 + " |");
            } else {
                System.out.print(row + 1 + "  |");
            }
            for (int col = 0; col < size; col++) {
                System.out.print(" " + board[row][col].getValue() + " |");
            }
            System.out.println();
        }
    }

    public void openAllCells() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                this.board[row][col].setOpenStatus();
            }
        }
    }

    public void renderColumnNumbers() {
        System.out.print("     ");
        for (int col = 0; col < size; col++) {
            if (col >= 9) {
                System.out.print(col + 1 + "  ");
            } else {
                System.out.print(col + 1 + "   ");
            }
        }
        System.out.println();
    }

    // createBoard

    // playMove
    // IF moveCoordinatesAreValid

    // allNoneBombCellsAreOpened

}
