package com.danyazero.learnlang;

import Service.InterLayerService;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;
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
    private final InterLayerService service = new InterLayerService();

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
        service.isRandom(false);
        TextInputDialog dialog = new TextInputDialog("0");
        dialog.setTitle("Go to...");
        dialog.setHeaderText("Enter word id");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            Word word = service.getWordById(Integer.parseInt(result.get()));
            renderData(word);
        }
    }

    public void randomOrderOptionHandler(ActionEvent actionEvent) {
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Set Random Order");

        // Set the button types.
        ButtonType loginButtonType = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(20, 150, 10, 10));

        TextField from = new TextField();
        from.setPromptText("From");
        TextField to = new TextField();
        to.setPromptText("To");

        gridPane.add(from, 0, 0);;
        gridPane.add(to, 2, 0);

        dialog.getDialogPane().setContent(gridPane);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == loginButtonType) {
                return new Pair<>(from.getText(), to.getText());
            }
            return null;
        });

        Optional<Pair<String, String>> result = dialog.showAndWait();

        result.ifPresent(pair -> {
            System.out.println("From=" + pair.getKey() + ", To=" + pair.getValue());
            service.createRandomOrder(Integer.parseInt(pair.getKey()), Integer.parseInt(pair.getValue()));
            service.isRandom(true);
        });
    }

    public void offRandomOrderHandler(ActionEvent actionEvent) {
        service.isRandom(false);
    }
}