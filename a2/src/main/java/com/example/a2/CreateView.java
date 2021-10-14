package com.example.a2;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.Calendar;

public class CreateView extends GridPane {
    private Label name;
    private Label startDate;
    private Label description;
    private TextField nameField;
    private DatePicker datePicker;
    private TextArea descriptionField;
    private Button button;

    public CreateView(){
        VBox labelBox = new VBox(25);
        VBox fields = new VBox(15);

        name = new Label("Name: ");
        startDate = new Label("Start Date: ");
        description = new Label("Description: ");
        labelBox.getChildren().addAll(name,startDate,description);
        this.addColumn(0,labelBox);

        nameField = new TextField();
        datePicker = new DatePicker();
        descriptionField = new TextArea();
        button = new Button("Create");
        button.setFont(Font.font(24));
        fields.getChildren().addAll(nameField, datePicker, descriptionField, button);
        this.addColumn(1, fields);

        this.setPadding(new Insets(10,10,10,10));
        this.setAlignment(Pos.CENTER);

    }
}
