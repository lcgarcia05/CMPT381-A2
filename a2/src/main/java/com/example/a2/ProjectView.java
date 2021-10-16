package com.example.a2;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import java.time.LocalTime;

public class ProjectView extends FlowPane implements ProjectModelSubscriber{
    private Button startButton;
    private Button stopButton;
    private ListView<Project> projectListView;
    private ProjectModel model;
    private Label status;
    private String DEFAULT_STATUS = "Idle";

    public ProjectView(){
        VBox buttons = new VBox(25);

        projectListView = new ListView<>();
        startButton = new Button("Start");
        stopButton = new Button("Stop");
        status = new Label("Status: " + DEFAULT_STATUS);
        status.setPadding(new Insets(25));
        buttons.getChildren().addAll(startButton, stopButton, status);
        startButton.setFont(Font.font(26));
        startButton.setPadding(new Insets(25));
        stopButton.setPadding(new Insets(25));
        stopButton.setFont(Font.font(26));
        status.setFont(Font.font(20));
        buttons.setAlignment(Pos.TOP_CENTER);
        this.setHgap(5);
        this.setOrientation(Orientation.HORIZONTAL);
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(projectListView, buttons);
    }

    public void setModel(ProjectModel newModel){
        this.model = newModel;
        projectListView.setItems(model.getProjectList());

    }

    public void setController(ProjectController newController){
        startButton.setOnAction(e-> {
            try{
                newController.setCurrentProject(projectListView.getSelectionModel().getSelectedItem());
                newController.setIndex(projectListView.getSelectionModel().getSelectedIndex());
                // Uncomment for testing
                newController.setStartTime(LocalTime.of(5,45));
                // Comment if above is uncommented
                newController.setStartTime(LocalTime.now());

                startButton.setDisable(true);
                stopButton.setDisable(false);
                newController.setStatus("Working");
                newController.handleClickStartButton(e);
            }catch (NullPointerException exception){
                System.out.println("Model is null!!");
            }


        });

        stopButton.setOnAction(e -> {
            try{
                newController.setCurrentProject(projectListView.getSelectionModel().getSelectedItem());
                newController.setIndex(projectListView.getSelectionModel().getSelectedIndex());
                // Uncomment for testing
                newController.setEndTime(LocalTime.of(12,30));
                // Comment if above is uncommented
                newController.setEndTime(LocalTime.now());

                stopButton.setDisable(true);
                startButton.setDisable(false);
                newController.setStatus("Idle");
                newController.handleClickStopButton(e);
            }catch (NullPointerException exception){
                System.out.println("Model is null!!!");
            }


        });
    }

    @Override
    public void modelChanged() {
        status.setText("Status: " + model.getStatus());
    }
}
