package com.proofreader.server.Entity;

public class Question {
    private String content;
    private int id;
    private int number;
    private String solution;
    private int assignmentId;

    public Question(String content, int id, int number, String solution, int assignmentId) {
        this.content = content;
        this.number = number;
        this.solution = solution;
        this.id = id;
        this.assignmentId = assignmentId;
    }

    public Question() {}

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }
}
