package com.kodilla.tictactoe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class TicTacToe extends Application {

    public static GridPane grid = new GridPane();
    WincCheck win = new WincCheck();
    Font font = Font.font("Comic Sans MS", FontWeight.BOLD, 70);
    Scene scene = new Scene(grid, 700, 700);

    public void drawButtons() {
        for (int i = 0; i < 3; i++) {
            for (int n = 0; n < 3; n++) {

                Field button = new Field(i, n);
                button.setText("");
                button.setMinSize(150, 150);
                button.setFont(font);
                grid.add(button, i, n);

                button.setOnMouseClicked
                        (c -> {
                            if (button.getText().equals("")) {
                                button.setText("X");
                                if (win.isWin("X")) {
                                    win();
                                    return;
                                }
                                if (!canMove()) {
                                    remis();
                                    return;
                                }
                                makeCoputerMove();
                                if (win.isWin("O")) {
                                    lose();
                                    return;
                                }
                            }
                        });
            }
        }
    }

    public void makeCoputerMove() {

        List<Field> nodeList = grid.getChildren().stream()
                .filter(b -> b instanceof Field)
                .map(b -> (Field) b)
                .filter(b -> b.getText().equals(""))
                .collect(Collectors.toList());

        Random cpu = new Random();
        int nr = cpu.nextInt(nodeList.size());
        nodeList.get(nr).setText("O");
    }

    public boolean canMove() {

        List<Field> nodeList = grid.getChildren().stream()
                .filter(b -> b instanceof Field)
                .map(b -> (Field) b)
                .filter(b -> b.getText().equals(""))
                .collect(Collectors.toList());

        return nodeList.size() > 0;
    }

    public void win() {
        grid.getChildren().clear();
        Button message = new Button("Win");
        message.setFont(font);
        grid.add(message, 1, 1);
        message.setOnMouseClicked(c -> {
            grid.getChildren().clear();
            drawButtons();
        });
    }

    public void lose() {
        grid.getChildren().clear();
        Button message = new Button("Lose");
        message.setFont(font);
        grid.add(message, 1, 1);
        message.setOnMouseClicked(c -> {
            grid.getChildren().clear();
            drawButtons();
        });
    }

    public void remis() {
        grid.getChildren().clear();
        Button message = new Button("Remis");
        message.setFont(font);
        grid.add(message, 1, 1);
        message.setOnMouseClicked(c -> {
            grid.getChildren().clear();
            drawButtons();
        });
    }

    @Override
    public void start(Stage stage) {

        drawButtons();

        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setHgap(30);
        grid.setVgap(30);

        stage.setScene(scene);
        stage.setTitle("Tic Tac Toe");
        stage.show();
    }
}
