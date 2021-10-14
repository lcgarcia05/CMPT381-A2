package com.example.a2;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class StatusView extends GridPane {
    private Label status;
    private Button startButton;
    private Button pauseButton;
    private Button stopButton;

    public StatusView(){

        status = new Label("Status");
        startButton = new Button("Start");
        pauseButton = new Button("Pause");
        stopButton = new Button("Stop");

        this.add(status, 0,0);
        this.add(startButton, 1,0);
        this.add(pauseButton, 2,0);
        this.add(stopButton, 3,0);

        this.setHgap(10);
        this.setVgap(10);
        this.setAlignment(Pos.CENTER);
    }
}
