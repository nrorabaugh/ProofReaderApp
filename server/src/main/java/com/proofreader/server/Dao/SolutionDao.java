package com.proofreader.server.Dao;

import com.proofreader.server.Entity.Assignment;
import com.proofreader.server.Entity.Solution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class SolutionDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SolutionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Solution> getAllSolutions(){
        String sql = "" +
                "SELECT " +
                " id, " +
                " questionId, " +
                " assignmentId, " +
                " userId, " +
                " content, " +
                " correct, " +
                " submitted " +
                "FROM solution" ;

        return jdbcTemplate.query(sql, mapSolutionFromDb());
    }

    private RowMapper<Solution> mapSolutionFromDb() {
        return (resultSet, i) ->
                new Solution(
                        resultSet.getInt("id"),
                        resultSet.getInt("questionId"),
                        resultSet.getInt("assignmentId"),
                        resultSet.getInt("userId"),
                        resultSet.getString("content"),
                        resultSet.getBoolean("correct"),
                        resultSet.getBoolean("submitted")
                );
    }

    public List<Solution> getSolutionById(int id) {
        String sql = "" +
                "SELECT " +
                " id, " +
                " questionId, " +
                " assignmentId, " +
                " userId, " +
                " content, " +
                " correct, " +
                " submitted " +
                " FROM solution " +
                " WHERE id = ?";
        return jdbcTemplate.query(sql, mapSolutionFromDb(), id);
    }

    public List<Solution> getSolutionsByStudent(int userId) {
        String sql = "" +
                "SELECT " +
                " id, " +
                " questionId, " +
                " assignmentId, " +
                " userId, " +
                " content, " +
                " correct, " +
                " submitted " +
                " FROM solution " +
                " WHERE userId = ?";

        return jdbcTemplate.query(sql, mapSolutionFromDb(), userId);
    }

    public List<Solution> getSolutionsByQuestion(int questionId) {
        String sql = "" +
                "SELECT " +
                " id, " +
                " questionId, " +
                " assignmentId, " +
                " userId, " +
                " content, " +
                " correct, " +
                " submitted " +
                " FROM solution " +
                " WHERE questionId = ?";

        return jdbcTemplate.query(sql, mapSolutionFromDb(), questionId);
    }

    public List<Solution> getSolutionsByAssignment(int assignmentId) {
        String sql = "" +
                "SELECT " +
                " id, " +
                " questionId, " +
                " assignmentId, " +
                " userId, " +
                " content, " +
                " correct, " +
                " submitted " +
                " FROM solution " +
                " WHERE assignmentId = ?";

        return jdbcTemplate.query(sql, mapSolutionFromDb(), assignmentId);
    }

    public int deleteSolutionById(int id) {
        String sql = "" +
            "DELETE FROM solution " +
            "WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    public int updateSolutionById(Solution solution) {
        String sql = "" +
                "UPDATE solution " +
                "SET questionId = ? " +
                ",assignmentId = ?" +
                ",userId = ?" +
                ",content = ?" +
                ",correct = ?" +
                ",submitted = ?" +
                "WHERE id = ?";
        return jdbcTemplate.update(sql,
                solution.getQuestionId(),
                solution.getAssignmentId(),
                solution.getUserId(),
                solution.getContent(),
                solution.isCorrect(),
                solution.isSubmitted(),
                solution.getId()
        );
    }

    public int addSolution(Solution solution) {
        String sql = "" +
                "INSERT INTO solution (" +
                " questionId, " +
                " assignmentId, " +
                " userId, " +
                " content, " +
                " correct, " +
                " submitted)" +
                "VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                solution.getQuestionId(),
                solution.getAssignmentId(),
                solution.getUserId(),
                solution.getContent(),
                solution.isCorrect(),
                solution.isSubmitted()
        );
    }
}
