package com.company;

public class MineSweeper {
    Board board;
    Player player;

    public MineSweeper() {
        this.player = new Player();
        this.board = new Board(player.askForSize(), player.askForNumberOfMines());
        this.player.setBoardSize(board.getSize());
    }

    public void play(){
        int[] coordinates;
        String option;
        boolean gameLost = gameLost();
        boolean gameWon = gameWon();
        while (!gameWon && !gameLost) {
            board.render();
            option = player.askForAction();
            if (option.equals("c")) {
                coordinates = player.getCoordinates();
                boolean flagged = board.getBoard()[coordinates[0]][coordinates[1]].getFlagStatus();
                while (flagged) {
                    System.out.println("You flagged that cell. Choose a different coordinate.");
                    coordinates = player.getCoordinates();
                    flagged = board.getBoard()[coordinates[0]][coordinates[1]].getFlagStatus();
                }
                while (!board.getBoard()[coordinates[0]][coordinates[1]].getCloseStatus()) {
                    System.out.println("You already opened that cell. Choose a different coordinate.");
                    coordinates = player.getCoordinates();
                }
                playMove(coordinates);
            } else {
                coordinates = player.getCoordinates();
                this.board.placeFlag(coordinates);
            }
            // The order is important because gameLost() opens all the cells which the condition of gameWon()
            gameWon = gameWon();
            gameLost = gameLost();
        }
    }

    public boolean gameWon(){
        for (Cell[] row :
                this.board.getBoard()) {
            for (Cell cell :
                    row) {
                if (cell.getCloseStatus() && !cell.getValue().equals("*") && !cell.getValue().equals("0")) {
                    return false;
                }
            }
        }
        board.render();
        System.out.println("You won.");
        return true;
    }

    public boolean gameLost() {
        for (Cell[] row : this.board.getBoard()) {
            for (Cell cell : row) {
                if (cell.getDisplayValue().equals("*")) {
                    board.openAllCells();
                    board.render();
                    System.out.println("You Lost.");
                    return true;
                }
            }
        }
        return false;
    }

    public void playMove(int[] coordinates) {
        Cell cell = board.getCell(coordinates);
        cell.openCell();
        board.openAllEmptyCells(coordinates);
    }
}
