package com.proofreader.server.Service;

import com.proofreader.server.Dao.AssignmentDao;
import com.proofreader.server.Entity.Assignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AssignmentService {

    @Autowired
    private AssignmentDao dao;

    public Collection<Assignment> getAllAssignments() {
        return this.dao.getAllAssignments();
    }

    public Assignment getAssignmentById(int id) {
        return this.dao.getAssignmentById(id);
    }

    public Collection<Assignment> getAssignmentsByClass(int classId) { return this.dao.getAssignmentsByClass(classId); }

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
