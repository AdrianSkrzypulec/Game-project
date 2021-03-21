package com.kodilla.tictactoe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos; ;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.List;
import java.util.stream.Collectors;

public class TicTacToe extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Font font = Font.font("Comic Sans MS", FontWeight.BOLD, 70);
        GridPane grid = new GridPane();

            for (int i = 0; i < 3; i++){
                for (int n=0; n<3; n++) {

                    Field button = new Field(new Button(""), i, n);
                    button.getButton().setMinSize(150, 150);
                    button.getButton().setFont(font);
                    grid.add(button.getButton(), i, n);

                    if (button.getButton().getText() == "") {
                        button.getButton().setOnMouseClicked(c -> button.getButton().setText("X"));
//                        button.getButton().setOnMouseClicked(c -> System.out.println("Row;" + button.getRow() + " Col;" + button.getCol()));

                        List<Node> nodeList = grid.getChildren().stream()
                                .filter(b -> button.getButton().getText() == "")
                                .collect(Collectors.toList());

                        System.out.println(nodeList.size());
                    }
                }
            }

        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setHgap(30);
        grid.setVgap(30);

        Scene scene = new Scene(grid, 700, 700);

        stage.setScene(scene);
        stage.setTitle("Tic Tac Toe");
        stage.show();
    }
}
