package com.example.a2;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

/*
    The project controller, where it controls everything that is related to the project
    This is where the data is being processed from the view before sending to the model
 */
public class ProjectController {
    private ProjectModel model;
    private Project tempP;
    private DetailsView dView;
    private Stage stage;
    private Scene scene;


    public ProjectController(){
        stage = new Stage();
        dView = new DetailsView();
    }

    public void setModel(ProjectModel newModel){
        this.model = newModel;
    }

    public void setName(String name){
        model.setName(name);
    }

    public void setDatePicker(LocalDate datePicker){
        model.setDate(datePicker);
    }

    public void setDescription(String description){
        model.setDescription(description);
    }

    public void setCurrentProject(Project project){
        model.setCurrent(project);
    }

    public void setStartTime(LocalTime s){
        model.setStartTime(s);
    }

    public void setEndTime(LocalTime s){
        model.setEndTime(s);
    }

    public void setIndex(int i){
        model.setIndex(i);
    }

    public void setStatus(String s){
        model.setStatus(s);
    }

    public void setEndDate(LocalDate d){
        model.setEndDate(d);
    }

    public double calculateHours(LocalTime iTime , LocalTime fTime){
        return Duration.between(iTime, fTime).toHours();
    }

    public double calculateMinutes(LocalTime iTime , LocalTime fTime){
        return iTime.getMinute() - fTime.getMinute();
    }

    public void invoiceWindow(){

        dView.setModel(model);
        dView.setController(this);
        model.addSubscriber(dView);
        scene = new Scene(dView, 300,300);
        stage.setTitle("Invoice Details");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.sizeToScene();
        stage.show();
    }


    public void handleClickCreateView(ActionEvent event){
        System.out.println(model.getName());
        System.out.println(model.getDate());
        System.out.println(model.getDescription());
        model.addProject(model.getName(), model.getDate(), model.getDescription(), LocalTime.of(0,0,0),
                LocalTime.of(0,0,0));
        System.out.println(model.getProjectList());
    }

    public void handleClickStartButton(ActionEvent event){
        try{
            tempP = model.getProjectList().get(model.getIndex());
            tempP.updateStartTime(model.getStartTime());
            model.updateProject(tempP, model.getIndex());

        }catch (Exception e){
            System.out.println("List is empty!");
        }
    }

    public void handleClickStopButton(ActionEvent event){
        try {
            tempP = model.getProjectList().get(model.getIndex());
            tempP.updateEndTime(model.getEndTime());
            model.updateProject(tempP, model.getIndex());
            tempP.updateTotalMinutes(calculateMinutes(model.getStartTime(), model.getEndTime()));
            tempP.updateTotalHours(calculateHours(model.getStartTime(), model.getEndTime()));
            System.out.println("Initial: " + model.getStartTime());
            System.out.println("End: " + model.getEndTime());
            System.out.println("TotalHours: " + tempP.getTotalHours());
        }catch (Exception e){
            System.out.println("List is empty!");
        }

    }

    public void handleClicksInvoiceButton(ActionEvent event){
        invoiceWindow();
    }

    public void handleClicksCancelButton(ActionEvent event){
        stage.hide();
    }



}
