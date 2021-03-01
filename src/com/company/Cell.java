package com.company;

public class Cell {
    private boolean openStatus = false;
    private String value;

    public Cell(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public String getDisplayValue() {
        return openStatus ? this.value : "?";
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setOpenStatus() {
        openStatus = true;
    }

    public boolean getOpenStatus() {
        return openStatus;
    }
}
