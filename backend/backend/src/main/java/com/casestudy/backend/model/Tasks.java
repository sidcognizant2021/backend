package com.casestudy.backend.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "TASKS")
public class Tasks {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    
    @Column(name = "title")
    String title;
    
    @Column(name = "details")
    String details;
    
    @Column(name = "when")
    String when;
    
    @Column(name = "deadline")
    Date deadline;
    
    @Column(name = "is_project")
    boolean isProject;
    
    @Column(name = "parent")
    int parent;
    
    @Column(name = "done")
    boolean done;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getWhen() {
        return when;
    }

    public void setWhen(String when) {
        this.when = when;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public boolean isProject() {
        return isProject;
    }

    public void setProject(boolean project) {
        isProject = project;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}