package com.proofreader.server.Dao;

import com.proofreader.server.Entity.Assignment;
import com.proofreader.server.Entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class QuestionDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public QuestionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Question> getAllQuestions(){
        String sql = "" +
                "SELECT " +
                " id, " +
                " assignmentId, " +
                " number, " +
                " content, " +
                " solution " +
                "FROM question" ;

        return jdbcTemplate.query(sql, mapQuestionFromDb());
    }

    private RowMapper<Question> mapQuestionFromDb() {
        return (resultSet, i) ->
                new Question(
                        resultSet.getInt("id"),
                        resultSet.getInt("assignmentId"),
                        resultSet.getInt("number"),
                        resultSet.getString("content"),
                        resultSet.getString("solution")
                );
    }

    public List<Question> getQuestionById(int id) {
        String sql = "" +
                "SELECT " +
                " id, " +
                " assignmentId, " +
                " number, " +
                " content, " +
                " solution " +
                " FROM question " +
                " WHERE id = ?";
        return jdbcTemplate.query(sql, mapQuestionFromDb(), id);
    }

    public List<Question> getQuestionsByAssignment(int assignmentId) {
        String sql = "" +
                "SELECT " +
                " id, " +
                " assignmentId, " +
                " number, " +
                " content, " +
                " solution " +
                " FROM question " +
                " WHERE assignmentId = ?";

        return jdbcTemplate.query(sql, mapQuestionFromDb(), assignmentId);
    }

    public int deleteQuestionById(int id) {
        String sql = "" +
                "DELETE FROM question " +
                "WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    public int updateQuestionById(Question question) {
        String sql = "" +
                "UPDATE question " +
                "SET assignmentId = ? " +
                ",number = ?" +
                ",content = ?" +
                ",solution = ?" +
                "WHERE id = ?";
        return jdbcTemplate.update(sql,
                question.getAssignmentId(),
                question.getNumber(),
                question.getContent(),
                question.getSolution(),
                question.getId()
        );
    }

    public int addQuestion(Question question) {
        String sql = "" +
                "INSERT INTO question (" +
                " assignmentId, " +
                " number, " +
                " content, " +
                " solution) " +
                "VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                question.getAssignmentId(),
                question.getNumber(),
                question.getContent(),
                question.getSolution()
        );
    }
}

