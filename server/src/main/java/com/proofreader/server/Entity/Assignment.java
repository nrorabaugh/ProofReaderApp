package com.proofreader.server.Entity;

public class Assignment {
    private int id;
    private int classId;
    private String name;
    private String description;

    public Assignment(int id, int classId, String name, String description) {
        this.id = id;
        this.classId = classId;
        this.name = name;
        this.description = description;
    }

    public Assignment() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

