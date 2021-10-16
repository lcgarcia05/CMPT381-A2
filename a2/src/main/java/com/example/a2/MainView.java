package com.example.a2;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class MainView extends BorderPane {
    private Button createButton;
    private Button projectButton;
    private Button invoiceButton;
    private Label calendar;
    private Rectangle rec;
    private Rectangle rec2;
    private Rectangle rec3;
    private Label recentProj;
    private Label summary;
    private MainModel model;

    public MainView(){
        VBox leftItems = new VBox(15);
        VBox centerItems = new VBox();
        VBox rightItems = new VBox(15);
        createButton = new Button("Create");
        projectButton = new Button("Projects");
        invoiceButton = new Button("Invoice");

        createButton.setFont(Font.font(24));
        projectButton.setFont(Font.font(24));
        invoiceButton.setFont(Font.font(24));

        rec = new Rectangle(300,200);
        rec.setStroke(Color.BLACK);
        rec.setFill(Color.TRANSPARENT);

        rec2 = new Rectangle(100,80);
        rec2.setStroke(Color.BLACK);
        rec2.setFill(Color.TRANSPARENT);

        rec3 = new Rectangle(100,80);
        rec3.setStroke(Color.BLACK);
        rec3.setFill(Color.TRANSPARENT);

        calendar = new Label("Calendar\nTo be implemented");
        recentProj = new Label("Recent Project\nTo be implemented");
        summary = new Label("Summary\nTo be implemented");


        leftItems.setAlignment(Pos.CENTER);
        leftItems.getChildren().addAll(createButton,projectButton,invoiceButton);

        centerItems.getChildren().addAll(calendar,rec);
        centerItems.setAlignment(Pos.CENTER);

        rightItems.setAlignment(Pos.CENTER);
        rightItems.getChildren().addAll(recentProj,rec2, summary, rec3);

        this.setLeft(leftItems);
        this.setCenter(centerItems);
        this.setRight(rightItems);
    }

    public void setModel(MainModel newModel){
        this.model = newModel;
    }

    public void setController(MainController newController){
        createButton.setOnAction(newController::handleClick);
        projectButton.setOnAction(newController::handleClick2);
        invoiceButton.setOnAction(newController::handleClick3);
    }

}
