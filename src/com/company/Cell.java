package com.company;

public class Cell {
    private boolean openStatus = false;
    private boolean isFlagged = false;

    private String value;

    public Cell(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public String getDisplayValue() {
        if (openStatus) {
            return this.value;
        }else if (isFlagged) {
            return "f";
        }else {
            return "?";
        }
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void toggleOpenStatus() {
        openStatus = !openStatus;
    }

    public boolean getOpenStatus() {
        return openStatus;
    }

    public void toggleIsFlagged() { this.isFlagged = !isFlagged; }

    public boolean getFlagStatus() { return this.isFlagged; }
}
