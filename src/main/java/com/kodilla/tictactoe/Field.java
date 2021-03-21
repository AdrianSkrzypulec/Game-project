package com.kodilla.tictactoe;

import javafx.scene.Node;
import javafx.scene.control.Button;

public class Field extends Node {

    Button button;
    int row;
    int col;

    public Field(Button button, int col, int row) {
        this.button = button;
        this.row = row;
        this.col = col;
    }

    public Button getButton() {
        return button;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
