package com.example.a2;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import java.time.LocalDate;


/*
    View responsible for creating and adding the project
    It is triggered by clicking the Create button in the main menu
 */
public class CreateView extends GridPane{
    private Label name;
    private Label startDate;
    private Label description;
    private TextField nameField;
    private DatePicker datePicker;
    private TextArea descriptionField;
    private Button button;
    private ProjectModel model;

    public CreateView(){
        VBox labelBox = new VBox(25);
        VBox fields = new VBox(15);

        name = new Label("Name: ");
        startDate = new Label("Start Date: ");
        description = new Label("Description: ");
        labelBox.getChildren().addAll(name,startDate,description);
        this.addColumn(0,labelBox);

        nameField = new TextField();
        datePicker = new DatePicker(LocalDate.now());
        datePicker.getEditor().setDisable(true);
        descriptionField = new TextArea();
        button = new Button("Create");
        button.setFont(Font.font(24));
        fields.getChildren().addAll(nameField, datePicker, descriptionField, button);
        this.addColumn(1, fields);

        this.setPadding(new Insets(10,10,10,10));
        this.setAlignment(Pos.CENTER);

        button.setOnAction(e -> System.out.println(datePicker.getValue()));

    }

    public void setModel(ProjectModel newModel){
        this.model = newModel;

    }

    public void setController(ProjectController newController){
        button.setOnAction(e -> {
            newController.setName(nameField.getText());
            newController.setDatePicker(datePicker.getValue());
            newController.setDescription(descriptionField.getText());
            newController.handleClickCreateView(e);
        });
    }

}
