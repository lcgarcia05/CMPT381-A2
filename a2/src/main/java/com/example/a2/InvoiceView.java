package com.example.a2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.List;

public class InvoiceView extends FlowPane {
    private Button addButton;
    private Button invoiceButton;
    private ListView<String> projectList;
    private ListView<String> readyInvoice;
    private ObservableList<String> projects;
    private Label projectListLabel;
    private Label readyListLabel;

    public InvoiceView(){
        VBox leftItems = new VBox();
        VBox rightItems = new VBox();

        projectListLabel = new Label("Project List");
        projectList = new ListView<>();
        projects = FXCollections.observableArrayList("Test", "test2");
        projectList.setItems(projects);

        leftItems.setPrefSize(250,250);
        leftItems.setPadding(new Insets(15));
        leftItems.getChildren().addAll(projectListLabel,projectList);

        addButton = new Button("+");
        addButton.setFont(Font.font(16));

        readyListLabel = new Label("Ready to invoice");

        readyInvoice = new ListView<>();
        readyInvoice.setItems(projects);

        invoiceButton = new Button("Invoice");
        invoiceButton.setFont(Font.font(16));


        rightItems.setPrefSize(250,250);
        rightItems.setPadding(new Insets(15));
        rightItems.getChildren().addAll(readyListLabel, readyInvoice);

        this.setAlignment(Pos.CENTER);

        this.getChildren().addAll(leftItems, addButton,rightItems, invoiceButton);

    }


}
