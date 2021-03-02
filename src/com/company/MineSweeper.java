package com.company;

public class MineSweeper {
    private boolean gameFinished = false;
    Board board;
    Player player;
    public MineSweeper() {
        this.player = new Player();
        this.board = new Board(player.askForSize(), player.askForNumberOfMines());
    }

    public void play(){
        int[] coordinates;
        String option;
        while (!gameFinished) {
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
                playMove(coordinates);
            } else {
                coordinates = player.getCoordinates();
                this.board.placeFlag(coordinates);
            }
        }
    }

    public void playMove(int[] coordinates) {
        Cell cell = board.getCell(coordinates);
        cell.toggleOpenStatus();
        if (cell.getValue().equals("*")) {
            gameFinished = true;
            board.openAllCells();
            board.render();
            System.out.println("Game Over");
        }
    }
}
