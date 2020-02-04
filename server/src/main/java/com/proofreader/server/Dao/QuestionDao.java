package com.proofreader.server.Dao;

import com.proofreader.server.Entity.Question;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@Repository
public class QuestionDao {

    public static Map<Integer, Question> questions;

    static {
        questions = new HashMap<Integer, Question>() {
            {
                put(1, new Question(
                        "This is an algebra question", 1, 1, "x^2 + 2x + 1", 1
                ));
            }
        };
    }

    public Collection<Question> getAllQuestions() {
        return questions.values();
    }

    public Question getQuestionById(int id) { return questions.get(id); }

    public Collection<Question> getQuestionsByAssignment(int assignmentId) {
        Collection<Question> questionsRaw = questions.values();
        Collection<Question> questionsParse = new LinkedList<Question>();
        for(Question i : questionsRaw ) {
            if(i.getAssignmentId() == assignmentId) {
                questionsParse.add(i);
            }
        }
        return questionsParse;
    }

    public void deleteQuestionById(int id) {
        questions.remove(id);
    }

    public void updateQuestionById(Question question) {
        Question questionToUpdate = questions.get(question.getId());
        questionToUpdate.setAssignmentId(question.getAssignmentId());
        questionToUpdate.setContent(question.getContent());
        questionToUpdate.setId(question.getId());
        questionToUpdate.setNumber(question.getNumber());
        question.setSolution(question.getSolution());
        questions.put(question.getId(), question);
    }

    public void addQuestion(Question assignment) {
        questions.put(assignment.getId(), assignment);
    }
}
