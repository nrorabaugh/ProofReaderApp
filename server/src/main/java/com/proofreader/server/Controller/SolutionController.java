package com.proofreader.server.Controller;

import com.proofreader.server.Entity.Solution;
import com.proofreader.server.Service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/solutions")
public class SolutionController {

    @Autowired
    private SolutionService solutionService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Solution> getAllSolutions() {
        return solutionService.getAllSolutions();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public List<Solution> getSolution(@PathVariable("id") int id) {
        return solutionService.getSolutionById(id);
    }

    @RequestMapping(value = "/question/{id}", method = RequestMethod.GET)
    public Collection<Solution> getSolutionsByQuestion(@PathVariable("id") int questionId) { return solutionService.getSolutionsByQuestion(questionId); }

    @RequestMapping(value = "/assignment/{id}", method = RequestMethod.GET)
    public Collection<Solution> getSolutionsByAssignment(@PathVariable("id") int assignmentId) { return solutionService.getSolutionsByAssignment(assignmentId); }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public Collection<Solution> getSolutionsByStudent(@PathVariable("id") int studentId) { return solutionService.getSolutionsByStudent(studentId); }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteSolutionById(@PathVariable("id") int id) {
        solutionService.deleteSolutionById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateSolutionById(@RequestBody Solution solution) {
        solutionService.updateSolutionById(solution);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addSolution(@RequestBody Solution solution){
        solutionService.addSolution(solution);
    }
}
