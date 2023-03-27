package com.danyazero.learnlang;

import IO.IOProcessor;
import IO.IO;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import models.FileOutput;

import java.util.List;

public class MainController {
    public MenuBar menuBar;
    public Label bottomText;
    public Label topText;
    public Label idLabel;

    private int id = 0;
    private IO io = new IOProcessor();
    private List<FileOutput> list;

    public void initialize(){
        list = io.readObjectsFromJSON();
        topText.setText(list.get(id).getTranslate());
        bottomText.setText(getEnglishTranslate(list));
        idLabel.setText(String.valueOf(id));
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
        if (id < list.size()-1){
            id++;
            renderData();
        }
    }

    private void renderData(){
        bottomText.setVisible(false);
        topText.setText(list.get(id).getTranslate());
        bottomText.setText(getEnglishTranslate(list));
        idLabel.setText(String.valueOf(id));
    }

    private String getEnglishTranslate(List<FileOutput> words) {
        StringBuilder sb = new StringBuilder();
        sb.append(words.get(id).getFirstForm()).append(", ").append(words.get(id).getSecondForm()).append(", ").append(words.get(id).getThirdForm());

        return sb.toString();
    }

    public void previousButtonHandler(ActionEvent actionEvent) {
        if (id > 0){
            id--;
            renderData();
        }
    }
}