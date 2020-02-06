package com.proofreader.server.Dao;

import com.proofreader.server.Entity.Assignment;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@Repository
public class AssignmentDao {

    public static Map<Integer, Assignment> assignments;

    static {
        assignments = new HashMap<Integer, Assignment>() {
            {
                put(1, new Assignment(1,
                        "Assignment Name",
                        "Ass description",
                        1
                ));
            }
        };
    }

    public Collection<Assignment> getAllAssignments() {
        return assignments.values();
    }

    public Assignment getAssignmentById(int id) { return assignments.get(id); }

    public Collection<Assignment> getAssignmentsByClass(int classId) {
        Collection<Assignment> assignmentsRaw = assignments.values();
        Collection<Assignment> assignmentsParse = new LinkedList<Assignment>();
        for(Assignment i : assignmentsRaw ) {
            if(i.getClassId() == classId) {
                assignmentsParse.add(i);
            }
        }
        return assignmentsParse;
    }

    public void deleteAssignmentById(int id) {
        assignments.remove(id);
    }

    public void updateAssignmentById(Assignment assignment) {
        Assignment assignmentToUpdate = assignments.get(assignment.getId());
        assignmentToUpdate.setClassId(assignment.getClassId());
        assignmentToUpdate.setDescription(assignment.getDescription());
        assignments.put(assignment.getId(), assignment);
    }

    public void addAssignment(Assignment assignment) {
        assignments.put(assignment.getId(), assignment);
    }
}
