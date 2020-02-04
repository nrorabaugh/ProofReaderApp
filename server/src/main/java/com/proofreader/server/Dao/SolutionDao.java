package com.proofreader.server.Dao;

import com.proofreader.server.Entity.Solution;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@Repository
public class SolutionDao {
    public static Map<Integer, Solution> solutions;

    static {
        solutions = new HashMap<Integer, Solution>() {
            {
                put(1, new Solution(false,
                        1,
                        1,
                        1,
                        1,
                        "This is user1's a1q1 solution"
                ));
                put(2, new Solution(false,
                        1,
                        2,
                        1,
                        2,
                        "This is user1's a2q1 solution"
                ));
                put(3, new Solution(false,
                        2,
                        1,
                        3,
                        3,
                        "This is user3's a1q2 solution"
                ));
            }
        };
    }

    public Collection<Solution> getAllSolutions() {
        return solutions.values();
    }

    public Solution getSolutionById(int id) { return solutions.get(id); }

    public Collection<Solution> getSolutionsByStudent(int userId) {
        Collection<Solution> solutionsRaw = solutions.values();
        Collection<Solution> solutionsParse = new LinkedList<Solution>();
        for(Solution i : solutionsRaw ) {
            if(i.getUserId() == userId) {
                solutionsParse.add(i);
            }
        }
        return solutionsParse;
    }

    public Collection<Solution> getSolutionsByQuestion(int questionId) {
        Collection<Solution> solutionsRaw = solutions.values();
        Collection<Solution> solutionsParse = new LinkedList<Solution>();
        for(Solution i : solutionsRaw ) {
            if(i.getQuestionId() == questionId) {
                solutionsParse.add(i);
            }
        }
        return solutionsParse;
    }

    public Collection<Solution> getSolutionsByAssignment(int assignmentId) {
        Collection<Solution> solutionsRaw = solutions.values();
        Collection<Solution> solutionsParse = new LinkedList<Solution>();
        for(Solution i : solutionsRaw ) {
            if(i.getAssignmentId() == assignmentId) {
                solutionsParse.add(i);
            }
        }
        return solutionsParse;
    }

    public void deleteSolutionById(int id) {
        solutions.remove(id);
    }

    public void updateSolutionById(Solution solution) {
        Solution solutionToUpdate = solutions.get(solution.getId());
        solutionToUpdate.setCorrect(solution.isCorrect());
        solutionToUpdate.setAssignmentId(solution.getAssignmentId());
        solutionToUpdate.setContent(solution.getContent());
        solutionToUpdate.setQuestionId(solution.getQuestionId());
        solutionToUpdate.setUserId(solution.getUserId());
        solutionToUpdate.setContent(solution.getContent());
        solutions.put(solution.getId(), solution);
    }

    public void addSolution(Solution solution) {
        solutions.put(solution.getId(), solution);
    }
}
