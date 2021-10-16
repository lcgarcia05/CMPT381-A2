package com.example.a2;

import javafx.event.ActionEvent;

/*
    Main menu controller
 */
public class MainController {
    private MainModel model;

    public MainController() {
    }

    public void setModel(MainModel newModel){
        this.model = newModel;
    }

    public void handleClick(ActionEvent actionEvent){
        model.swapScene1();
    }

    public void handleClick2(ActionEvent actionEvent){
        model.swapScene2();
    }

    public void handleClick3(ActionEvent actionEvent){
        model.swapScene3();
    }
}
