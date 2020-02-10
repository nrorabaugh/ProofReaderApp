package com.proofreader.server.Entity;

public class Calculation {
    private String expression;
    private String comment;
    private int solutionId;
    private int id;

    public Calculation(int id, int solutionId, String expression, String comment) {
        this.id = id;
        this.solutionId = solutionId;
        this.expression = expression;
        this.comment = comment;
    };

    public Calculation(){};

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getSolutionId() {
        return solutionId;
    }

    public void setSolutionId(int questionId) {
        this.solutionId = questionId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
