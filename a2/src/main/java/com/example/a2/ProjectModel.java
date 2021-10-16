package com.example.a2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/*
    The project model, where the data is stored and where it can be withdrawn
 */
public class ProjectModel {

    private ObservableList<Project> projects;
    private ArrayList<ProjectModelSubscriber> subs;
    private String name;
    private String status;
    private LocalDate date;
    private String description;
    private Project current;
    private LocalTime startTime;
    private LocalTime endTime;
    private int index;
    private LocalDate endDate;



    public ProjectModel(){
        projects = FXCollections.observableArrayList();
        subs = new ArrayList<>();
    }

    public void addSubscriber(ProjectModelSubscriber aSub){
        subs.add(aSub);
    }

    private void notifySubscribers(){
        subs.forEach(sub -> sub.modelChanged());
    }

    public ObservableList<Project> getProjectList(){
        return this.projects;
    }

    public void addProject(String name, LocalDate date, String description, LocalTime startTime, LocalTime endTIme){
        projects.add(new Project(name, date, description, startTime, endTIme));
        notifySubscribers();
    }

    public void updateProject(Project p, int index){
        projects.set(index, p);
    }

    public String getName() {
        notifySubscribers();

        return name;
    }

    public String getStatus() {

        return status;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public Project getCurrent() {
        return current;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public int getIndex() {
        return index;
    }


    public ProjectModel setName(String name) {
        this.name = name;
        notifySubscribers();
        return this;
    }

    public ProjectModel setStatus(String status) {
        this.status = status;
        notifySubscribers();

        return this;
    }

    public ProjectModel setDate(LocalDate date) {
        this.date = date;
        notifySubscribers();

        return this;
    }

    public ProjectModel setDescription(String description) {
        this.description = description;
        notifySubscribers();
        return this;
    }

    public ProjectModel setCurrent(Project current) {
        this.current = current;
        return this;
    }

    public ProjectModel setStartTime(LocalTime startTime) {
        this.startTime = startTime;
        notifySubscribers();
        return this;
    }

    public ProjectModel setEndTime(LocalTime endTime) {
        this.endTime = endTime;
        return this;
    }

    public ProjectModel setIndex(int index) {
        this.index = index;
        return this;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public ProjectModel setEndDate(LocalDate setEndDate) {
        this.endDate = setEndDate;
        notifySubscribers();

        return this;
    }
}
