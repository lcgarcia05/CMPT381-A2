package com.example.a2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Calendar;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        MainView mView = new MainView();
        CreateView cView = new CreateView();
        ProjectView pView = new ProjectView();
        InvoiceView iView = new InvoiceView();
        DetailsView dView = new DetailsView();
        StatusView sView = new StatusView();

        Scene scene = new Scene(sView, 700,400);
        stage.setTitle("TTracker");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}