package com.proofreader.server.Controller;

import com.proofreader.server.Entity.Assignment;
import com.proofreader.server.Service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/assignments")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Assignment> getAllAssignments() {
        return assignmentService.getAllAssignments();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Assignment getAssignmentById(@PathVariable("id") int id) {
        return assignmentService.getAssignmentById(id);
    }

    @RequestMapping(value = "/class/{id}", method = RequestMethod.GET)
    public Collection<Assignment> getAssignmentsByClass(@PathVariable("id") int id) {
        return assignmentService.getAssignmentsByClass(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteAssignmentById(@PathVariable("id") int id) {
        assignmentService.deleteAssignmentById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateAssignmentById(@RequestBody Assignment assignment) {
        assignmentService.updateAssignmentById(assignment);
    }

//    @RequestMapping(value = "/messages", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public void addMessage(@RequestBody Assignment.Message message) {
//        assignmentService.addMessage(message);
//    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addAssignment(@RequestBody Assignment assignment){
        assignmentService.addAssignment(assignment);
    }
}