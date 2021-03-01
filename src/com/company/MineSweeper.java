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
        int[] coodinates;
        while (!gameFinished) {
            board.render();
            coodinates = player.getCoordinates();
            playMove(coodinates);
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
