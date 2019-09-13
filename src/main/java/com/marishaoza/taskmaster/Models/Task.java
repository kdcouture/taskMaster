package com.marishaoza.taskmaster.Models;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;

@DynamoDBTable(tableName = "taskmaster")
public class Task {

    private String id;
    private String title;
    private String description;
    private String status;
    private String assignee;
    private String pic;

    private ArrayList<HistoryObj> history;

    public Task() {
        this.history = new ArrayList<>();
    }


    // ---------------- Getters & Setters ----------------

    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    @DynamoDBAttribute
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @DynamoDBAttribute
    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @DynamoDBAttribute
    public String getStatus() {
        return this.status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    @DynamoDBAttribute
    public String getAssignee() {
        return this.assignee;
    }
    public void setAssignee(String assignee) {
            this.assignee = assignee;
    }

    @DynamoDBAttribute
    public ArrayList<HistoryObj> getHistory() {
        return this.history;
    }
    public void setHistory(ArrayList<HistoryObj> history) {
        this.history = history;
    }

    @DynamoDBAttribute
    public String getPic() {
        return pic;
    }
    public void setPic(String pic) {
        this.pic = pic;
    }

    // ---------------- Methods ----------------

    public void addHistory(HistoryObj historyObj) {
        this.history.add(historyObj);
    }

}