package com.example.a2;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.time.LocalDate;
import java.time.LocalTime;

/*
    View responsible for getting the project ready for billing
 */
public class InvoiceView extends FlowPane{
    private Button addButton;
    private Button invoiceButton;
    private ListView<Project> projectList;
    private ListView<Project> readyInvoice;
    private Label projectListLabel;
    private Label readyListLabel;
    private ProjectModel model;

    public InvoiceView(){
        VBox leftItems = new VBox();
        VBox rightItems = new VBox();

        projectListLabel = new Label("Project List");
        projectList = new ListView<>();

        leftItems.setPrefSize(250,400);
        leftItems.setPadding(new Insets(15));
        leftItems.getChildren().addAll(projectListLabel,projectList);

        addButton = new Button("+");
        addButton.setFont(Font.font(16));

        readyListLabel = new Label("Ready to invoice");

        readyInvoice = new ListView<>();

        invoiceButton = new Button("Invoice");
        invoiceButton.setFont(Font.font(16));


        rightItems.setPrefSize(250,400);
        rightItems.setPadding(new Insets(15));
        rightItems.getChildren().addAll(readyListLabel, readyInvoice);

        this.setAlignment(Pos.CENTER);

        this.getChildren().addAll(leftItems, addButton,rightItems, invoiceButton);

    }

    public void setModel(ProjectModel newModel){
        model = newModel;
        projectList.setItems(model.getProjectList());
        readyInvoice.setItems(FXCollections.observableArrayList(new Project("For Test", LocalDate.now(), "For testing purposes", LocalTime.now(), LocalTime.now())));

    }

    public void setController(ProjectController newController){
        addButton.setOnAction(e-> {
            try{
                newController.setCurrentProject(projectList.getSelectionModel().getSelectedItem());
                newController.setIndex(projectList.getSelectionModel().getSelectedIndex());
                readyInvoice.getItems().addAll(model.getProjectList().get(model.getIndex()));
                newController.setEndDate(LocalDate.now());
            }catch (StackOverflowError | IndexOutOfBoundsException exception){
                System.out.println("Please highlight an item on the left list.");
            }

        });

        invoiceButton.setOnAction(e->{
            try{
                newController.handleClicksInvoiceButton(e);
            }catch (StackOverflowError | IndexOutOfBoundsException exception){
                System.out.println("Please highlight an item on the right list");
            }
        });
    }

}
