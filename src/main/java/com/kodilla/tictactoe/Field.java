package com.kodilla.tictactoe;

import javafx.scene.control.Button;

public class Field extends Button {

    int row;
    int col;

    public Field(int col, int row) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public String toString() {
        return "Field{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }
}
