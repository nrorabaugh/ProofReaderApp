package com.proofreader.server.Entity;

public class Classroom {
    private int id;
    private int teacherId;
    private String name;

    public Classroom(int id, int teacherId, String name) {
        this.id = id;
        this.name = name;
        this.teacherId = teacherId;
    }

    public Classroom() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}