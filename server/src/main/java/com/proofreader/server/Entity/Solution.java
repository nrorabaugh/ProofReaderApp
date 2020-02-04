package com.proofreader.server.Entity;

public class Solution {
    private boolean correct;
    private int questionId;
    private int assignmentId;
    private int userId;
    private int id;
    private String content;

    public Solution(boolean correct, int questionId, int assignmentId, int userId, int id, String content) {
        this.correct = correct;
        this.questionId = questionId;
        this.assignmentId = assignmentId;
        this.userId = userId;
        this.id = id;
        this.content = content;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
