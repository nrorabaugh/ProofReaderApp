package com.proofreader.server.Service;

import com.proofreader.server.Dao.SolutionDao;
import com.proofreader.server.Entity.Solution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class SolutionService {

    @Autowired
    private SolutionDao dao;

    public List<Solution> getAllSolutions() {
        return this.dao.getAllSolutions();
    }

    public List<Solution> getSolutionById(int id) {
        return this.dao.getSolutionById(id);
    }

    public List<Solution> getSolutionsByAssignment(int assignmentId) { return this.dao.getSolutionsByAssignment(assignmentId); }

    public List<Solution> getSolutionsByStudent(int userId) { return this.dao.getSolutionsByStudent(userId); }

    public List<Solution> getSolutionsByQuestion(int questionId) { return this.dao.getSolutionsByQuestion(questionId); }

    public void deleteSolutionById(int id) {
        this.dao.deleteSolutionById(id);
    }

    public void updateSolutionById(Solution solution) {
        this.dao.updateSolutionById(solution);
    }

    public void addSolution(Solution solution) {
        this.dao.addSolution(solution);
    }
}
