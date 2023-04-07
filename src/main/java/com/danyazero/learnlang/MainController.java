package com.danyazero.learnlang;

import Service.Service;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextInputDialog;
import models.Word;

import java.util.Optional;

public class MainController {
    @FXML
    private MenuBar menuBar;
    @FXML
    private Label bottomText;
    @FXML
    private Label topText;
    @FXML
    private Label idLabel;
    private final Service service = new Service();

    public void initialize() {
        Word word = service.getWordById(0);
        renderData(word);

    }

    public void showAnswer(ActionEvent actionEvent) {
        bottomText.setVisible(!bottomText.isVisible());
    }

    public void nextButtonHandler(ActionEvent actionEvent) {
        Word word = service.next();
        renderData(word);
    }

    private void renderData(Word word) {
        if (word != null) {
            bottomText.setVisible(false);
            topText.setText(word.getTranslate());
            bottomText.setText(word.getEnglish());
            idLabel.setText(String.valueOf(service.id()));
        }
    }

    public void previousButtonHandler(ActionEvent actionEvent) {
        Word word = service.previous();
        renderData(word);
    }

    public void goToOptionHandler(ActionEvent actionEvent) {
        TextInputDialog dialog = new TextInputDialog("0");
        dialog.setTitle("Go to...");
        dialog.setHeaderText("Enter word id");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            Word word = service.getWordById(Integer.parseInt(result.get()));
            renderData(word);
        }
    }
}