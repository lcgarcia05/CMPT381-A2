package com.example.a2;

import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/*
    Main menu model, this handles the opening of new windows for certain views
 */
public class MainModel {
    private Scene scene;
    private CreateView cView;
    private ProjectView pView;
    private InvoiceView iView;
    private Stage stage;
    private Stage parent;
    ProjectModel pModel;
    ProjectController pController;


    public MainModel(Stage s) {
        this.parent = s;
        pModel = new ProjectModel();
        pController = new ProjectController();

    }

    public void swapScene1(){
        stage = new Stage();
        this.cView = new CreateView();

        cView.setModel(pModel);
        cView.setController(pController);
        pController.setModel(pModel);


        scene = new Scene(cView, 600,300);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.setTitle("Create a project");
        stage.setResizable(false);
        stage.show();
    }

    public void swapScene2(){
        stage = new Stage();
        this.pView = new ProjectView();

        pView.setModel(pModel);
        pView.setController(pController);
        pModel.addSubscriber(pView);


        scene = new Scene(pView, 600,600);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.setTitle("Projects");
        stage.setResizable(false);
        stage.show();
    }

    public void swapScene3(){
        stage = new Stage();
        this.iView = new InvoiceView();

        iView.setModel(pModel);
        iView.setController(pController);


        scene = new Scene(iView, 600,600);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Invoice");
        stage.sizeToScene();
        stage.show();
    }


}
