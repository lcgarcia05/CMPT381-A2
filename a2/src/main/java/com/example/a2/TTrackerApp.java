package com.example.a2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class TTrackerApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        // MVC Setup
        MainView mView = new MainView();
        MainModel mModel = new MainModel(stage);
        MainController mController = new MainController();
        mView.setModel(mModel);
        mView.setController(mController);
        mController.setModel(mModel);


        Scene scene = new Scene(mView, 700,400);
        stage.setTitle("TTracker");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.sizeToScene();
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}