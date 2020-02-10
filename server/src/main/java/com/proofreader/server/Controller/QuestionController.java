package com.proofreader.server.Controller;

import com.proofreader.server.Entity.Question;
import com.proofreader.server.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Question> getAllAssignments() {
        return questionService.getAllQuestions();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public List<Question> getQuestion(@PathVariable("id") int id) {
        return questionService.getQuestionById(id);
    }

    @RequestMapping(value = "/assignment/{id}", method = RequestMethod.GET)
    public List<Question> getQuestionsByAssignment(@PathVariable("id") int id) {
        return questionService.getQuestionsByAssignment(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteAssignmentById(@PathVariable("id") int id) {
        questionService.deleteQuestionById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateAssignmentById(@RequestBody Question question) {
        questionService.updateQuestionById(question);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addAssignment(@RequestBody Question question){
        questionService.addQuestion(question);
    }
}

