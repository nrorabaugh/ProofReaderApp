package com.proofreader.server.Dao;

import com.proofreader.server.Entity.Assignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class AssignmentDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AssignmentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Assignment> getAllAssignments(){
        String sql = "" +
                "SELECT " +
                " id, " +
                " classId, " +
                " name, " +
                " description " +
                "FROM assignment" ;

        return jdbcTemplate.query(sql, mapAssignmentFromDb());
    }

    private RowMapper<Assignment> mapAssignmentFromDb() {
        return (resultSet, i) ->
                new Assignment(
                        resultSet.getInt("id"),
                        resultSet.getInt("classId"),
                        resultSet.getString("name"),
                        resultSet.getString("description")
                );
    }

    public List<Assignment> getAssignmentById(int id) {
        String sql = "" +
                "SELECT " +
                " id, " +
                " classId, " +
                " name, " +
                " description " +
                " FROM assignment " +
                " WHERE id = ?";
        return jdbcTemplate.query(sql, mapAssignmentFromDb(), id);
    }

    public List<Assignment> getAssignmentByName(String name) {
        String sql = "" +
                "SELECT " +
                " id, " +
                " classId, " +
                " name, " +
                " description " +
                " FROM assignment " +
                " WHERE name = ?";
        return jdbcTemplate.query(sql, mapAssignmentFromDb(), name);
    }

    public List<Assignment> getAssignmentsByClass(int classId) {
        String sql = "" +
                "SELECT " +
                " id, " +
                " classId, " +
                " name, " +
                " description " +
                " FROM assignment " +
                " WHERE classId = ?";

        return jdbcTemplate.query(sql, mapAssignmentFromDb(), classId);
    }

    public int deleteAssignmentById(int id) {
        String sql = "" +
                "DELETE FROM assignment " +
                "WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    public int updateAssignmentById(Assignment assignment) {
        String sql = "" +
                "UPDATE assignment " +
                "SET classId = ? " +
                ",name = ?" +
                ",description = ?" +
                "WHERE id = ?";
        return jdbcTemplate.update(sql,
                assignment.getClassId(),
                assignment.getName(),
                assignment.getDescription(),
                assignment.getId()
        );
    }

    public int addAssignment(Assignment assignment) {
        String sql = "" +
                "INSERT INTO assignment (" +
                " classId, " +
                " name, " +
                " description) " +
                "VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql,
                assignment.getClassId(),
                assignment.getName(),
                assignment.getDescription()
        );
    }
}
