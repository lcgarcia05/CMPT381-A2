package com.example.a2;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/*
    A view that is responsible for presenting the project's details
    The state where the project has been already invoiced.
 */
public class DetailsView extends GridPane implements ProjectModelSubscriber{
    private Label header;
    private Button exportButton;
    private Button cancelButton;
    private Label name;
    private Label startDate;
    private Label description;
    private Label totalHours;
    private Label endDate;

    private ProjectModel model;

    public DetailsView(){
        VBox ele = new VBox();
        HBox buttons = new HBox();
        VBox details = new VBox();
        header = new Label("Invoice Details");
        name = new Label("Project Name: ");
        startDate = new Label("Start Date: ");
        description = new Label("Description: ");
        totalHours = new Label("Total Hours: ");
        endDate = new Label("End Date: ");
        details.getChildren().addAll(name,startDate,description,totalHours,endDate);

        exportButton = new Button("Export");
        cancelButton = new Button("Cancel");

        buttons.getChildren().addAll(exportButton, cancelButton);
        buttons.setAlignment(Pos.CENTER);
        buttons.setPadding(new Insets(15));
        buttons.setSpacing(15);
        ele.getChildren().addAll(header,details,buttons);

        this.setAlignment(Pos.CENTER);
        this.getChildren().add(ele);

    }

    public void setModel(ProjectModel newModel){
        this.model = newModel;
        modelChanged();
    }

    public void setController(ProjectController newController){
        cancelButton.setOnAction(newController::handleClicksCancelButton);
        exportButton.setOnAction(e->{
            exportButton.setText("To be implemented");
        });
    }

    @Override
    public void modelChanged() {
        name.setText("Project Name: " + model.getName());
        startDate.setText("Start Date: " + model.getDate());
        description.setText("Description: " + model.getDescription());
        totalHours.setText("Total Hours: " + model.getProjectList().get(model.getIndex()).getTotalHours());
        endDate.setText("End Date: " + model.getEndDate());
    }
}
