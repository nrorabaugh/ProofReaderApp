package com.proofreader.server.Entity;

public class User {
    private String username;
    private String password;
    private int classId;
    private int id;
    private String role;

    public User(int id, int classId, String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.classId = classId;
        this.id = id;
        this.role = role;
    }

    public User() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
