package com.company;

public class Cell {
    private boolean isOpen = false;
    private boolean isFlagged = false;

    private String value;

    public Cell(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public String getDisplayValue() {
        if (isOpen) {
            if (this.value.equals("0")){
                return " ";
            }else {
                return this.value;
            }
        }else if (isFlagged) {
            return "f";
        }else {
            return "?";
        }
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void openCell() {
        isOpen = true;
    }

    public boolean getCloseStatus() {
        return !isOpen;
    }

    public void toggleIsFlagged() { this.isFlagged = !isFlagged; }

    public boolean getFlagStatus() { return this.isFlagged; }
}
