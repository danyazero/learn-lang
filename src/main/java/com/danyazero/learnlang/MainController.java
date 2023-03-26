package com.danyazero.learnlang;

import IO.IOProcessor;
import IO.IO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.HBox;
import models.FileOutput;

import java.util.List;

public class MainController {
    public MenuBar menuBar;
    public Label bottomText;
    public Label topText;
    @FXML
    private Label welcomeText;

    private int id = 0;


    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to Zero lang Application!");
    }

    public void instagramLink(ActionEvent actionEvent) {
        IO io = new IOProcessor();

        List<FileOutput> list = io.readObjectsFromJSON();
        System.out.println(list);
    }

    public void showAnswer(ActionEvent actionEvent) {
        bottomText.setVisible(!bottomText.isVisible());
    }

    public void nextButtonHandler(ActionEvent actionEvent) {
        id++;
    }
}