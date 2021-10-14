package com.example.a2;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class DetailsView extends GridPane {
    private Label header;
    private Rectangle rectangle;
    private Button exportButton;
    private Button cancelButton;

    public DetailsView(){
        VBox ele = new VBox();
        HBox buttons = new HBox();
        header = new Label("Invoice Details");
        rectangle = new Rectangle(300,300);
        rectangle.setFill(Color.TRANSPARENT);
        rectangle.setStroke(Color.BLACK);
        exportButton = new Button("Export");
        cancelButton = new Button("Cancel");

        buttons.getChildren().addAll(exportButton, cancelButton);
        buttons.setAlignment(Pos.CENTER);
        buttons.setPadding(new Insets(15));
        buttons.setSpacing(15);
        ele.getChildren().addAll(header,rectangle,buttons);

        this.setAlignment(Pos.CENTER);
        this.getChildren().add(ele);

    }
}
