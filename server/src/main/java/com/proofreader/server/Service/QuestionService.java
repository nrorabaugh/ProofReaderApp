package com.proofreader.server.Service;

import com.proofreader.server.Dao.QuestionDao;
import com.proofreader.server.Entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionDao dao;

    public List<Question> getAllQuestions() {
        return this.dao.getAllQuestions();
    }

    public List<Question> getQuestionById(int id) {
        return this.dao.getQuestionById(id);
    }

    public List<Question> getQuestionsByAssignment(int id) { return this.dao.getQuestionsByAssignment(id); }

    public void deleteQuestionById(int id) {
        this.dao.deleteQuestionById(id);
    }

    public void updateQuestionById(Question question) {
        this.dao.updateQuestionById(question);
    }

    public void addQuestion(Question assignment) {
        this.dao.addQuestion(assignment);
    }
}
