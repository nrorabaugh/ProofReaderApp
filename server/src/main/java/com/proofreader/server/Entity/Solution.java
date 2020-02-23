package com.proofreader.server.Entity;

public class Solution {
    private boolean correct;
    private boolean submitted;
    private int questionId;
    private int assignmentId;
    private int userId;
    private int id;
    private String content;

    public Solution(int id, int questionId, int assignmentId, int userId, String content, boolean correct, boolean submitted) {
        this.id = id;
        this.questionId = questionId;
        this.assignmentId = assignmentId;
        this.userId = userId;
        this.content = content;
        this.correct = correct;
        this.submitted = submitted;
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

    public boolean isSubmitted() {
        return submitted;
    }

    public void setSubmitted(boolean submitted) {
        this.submitted = submitted;
    }
}
