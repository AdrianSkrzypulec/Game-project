package com.kodilla.tictactoe;

public class WincCheck {

    public boolean isWin(String symbol) {

        long R0 = TicTacToe.grid.getChildren().stream()
                .filter(b -> b instanceof Field)
                .map(b -> (Field) b)
                .filter(b -> b.getText().equals(symbol))
                .filter(b -> b.getRow() == 0)
                .count();

        long R1 = TicTacToe.grid.getChildren().stream()
                .filter(b -> b instanceof Field)
                .map(b -> (Field) b)
                .filter(b -> b.getText().equals(symbol))
                .filter(b -> b.getRow() == 1)
                .count();

        long R2 = TicTacToe.grid.getChildren().stream()
                .filter(b -> b instanceof Field)
                .map(b -> (Field) b)
                .filter(b -> b.getText().equals(symbol))
                .filter(b -> b.getRow() == 2)
                .count();

        long C0 = TicTacToe.grid.getChildren().stream()
                .filter(b -> b instanceof Field)
                .map(b -> (Field) b)
                .filter(b -> b.getText().equals(symbol))
                .filter(b -> b.getCol() == 0)
                .count();

        long C1 = TicTacToe.grid.getChildren().stream()
                .filter(b -> b instanceof Field)
                .map(b -> (Field) b)
                .filter(b -> b.getText().equals(symbol))
                .filter(b -> b.getCol() == 1)
                .count();

        long C2 = TicTacToe.grid.getChildren().stream()
                .filter(b -> b instanceof Field)
                .map(b -> (Field) b)
                .filter(b -> b.getText().equals(symbol))
                .filter(b -> b.getCol() == 2)
                .count();

        long D0 = TicTacToe.grid.getChildren().stream()
                .filter(b -> b instanceof Field)
                .map(b -> (Field) b)
                .filter(b -> b.getText().equals(symbol))
                .filter(b -> b.getCol() == 0 && b.getRow() == 0)
                .count();

        long D1 = TicTacToe.grid.getChildren().stream()
                .filter(b -> b instanceof Field)
                .map(b -> (Field) b)
                .filter(b -> b.getText().equals(symbol))
                .filter(b -> b.getCol() == 2 && b.getRow() == 2)
                .count();

        long D2 = TicTacToe.grid.getChildren().stream()
                .filter(b -> b instanceof Field)
                .map(b -> (Field) b)
                .filter(b -> b.getText().equals(symbol))
                .filter(b -> b.getCol() == 1 && b.getRow() == 1)
                .count();

        long D3 = TicTacToe.grid.getChildren().stream()
                .filter(b -> b instanceof Field)
                .map(b -> (Field) b)
                .filter(b -> b.getText().equals(symbol))
                .filter(b -> b.getCol() == 0 && b.getRow() == 2)
                .count();

        long D4 = TicTacToe.grid.getChildren().stream()
                .filter(b -> b instanceof Field)
                .map(b -> (Field) b)
                .filter(b -> b.getText().equals(symbol))
                .filter(b -> b.getCol() == 2 && b.getRow() == 0)
                .count();

        return  R0 == 3 || R1 == 3 || R2 == 3 ||
                C0 == 3 || C1 == 3 || C2 == 3 ||
                D0 + D1 + D2 == 3 || D2 + D3 + D4 == 3;
    }
}