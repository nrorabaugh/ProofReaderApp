package com.proofreader.server.Service;

import com.proofreader.server.Dao.AssignmentDao;
import com.proofreader.server.Entity.Assignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentService {

    @Autowired
    private AssignmentDao dao;

    public List<Assignment> getAllAssignments() {
        return this.dao.getAllAssignments();
    }

    public List<Assignment> getAssignmentById(int id) {
        return this.dao.getAssignmentById(id);
    }

    public List<Assignment> getAssignmentByName(String name) {
        return this.dao.getAssignmentByName(name);
    }

    public List<Assignment> getAssignmentsByClass(int classId) { return this.dao.getAssignmentsByClass(classId); }

    public void deleteAssignmentById(int id) {
        this.dao.deleteAssignmentById(id);
    }

    public void updateAssignmentById(Assignment assignment) {
        this.dao.updateAssignmentById(assignment);
    }

    public void addAssignment(Assignment assignment) {
        this.dao.addAssignment(assignment);
    }
}
