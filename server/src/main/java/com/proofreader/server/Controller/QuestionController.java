package com.proofreader.server.Controller;

import com.proofreader.server.Entity.Question;
import com.proofreader.server.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionService assignmentService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Question> getAllAssignments() {
        return assignmentService.getAllQuestions();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Question getQuestion(@PathVariable("id") int id) {
        return assignmentService.getQuestionById(id);
    }

    @RequestMapping(value = "/assignment/{id}", method = RequestMethod.GET)
    public Collection<Question> getQuestionsByAssignment(@PathVariable("id") int id) {
        return assignmentService.getQuestionsByAssignment(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteAssignmentById(@PathVariable("id") int id) {
        assignmentService.deleteQuestionById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateAssignmentById(@RequestBody Question question) {
        assignmentService.updateQuestionById(question);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addAssignment(@RequestBody Question question){
        assignmentService.addQuestion(question);
    }
}

