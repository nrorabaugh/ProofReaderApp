package com.proofreader.server.Entity;

public class Message {
    private int id;
    private int senderId;
    private String content;
    private int assignmentId;
    private String eq;

    public Message(int id, int senderId, String content, int assignmentId, String eq) {
        this.id = id;
        this.senderId = senderId;
        this.assignmentId = assignmentId;
        this.content = content;
        this.eq = eq;
    }

    public Message() {}

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEq() {
        return eq;
    }

    public void setEq(String eq) {
        this.eq = eq;
    }
}
