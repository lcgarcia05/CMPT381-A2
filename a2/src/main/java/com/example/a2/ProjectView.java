package com.example.a2;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ProjectView extends FlowPane {
    private Button button;

    public ProjectView(){

//        for (int i=0; i<3; i++){
//            Rectangle test = new Rectangle(150,400);
//            test.setStroke(Color.BLACK);
//            test.setFill(Color.TRANSPARENT);
//            this.getChildren().add(test);
//        }

        for (int i=0; i<3; i++){
            VBox testBox = new VBox();
            testBox.getChildren().add(new Label("Project Details"));
            testBox.getChildren().add(new Button("Start"));
            testBox.setPrefSize(100,300);
            testBox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            this.getChildren().add(testBox);
        }

        this.setHgap(5);
        this.setOrientation(Orientation.HORIZONTAL);
//        this.setAlignment(Pos.CENTER);
    }

}
