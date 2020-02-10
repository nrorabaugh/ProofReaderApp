package com.proofreader.server.Dao;

import com.proofreader.server.Entity.Calculation;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CalculationDao {

    private final JdbcTemplate jdbcTemplate;

    public CalculationDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Calculation> getAllCalculations() {
            String sql = "" +
                    "SELECT " +
                    " id, " +
                    " solutionId, " +
                    " expression, " +
                    " comment " +
                    "FROM calculation" ;

            return jdbcTemplate.query(sql, mapCalculationFromDb());
    }

    private RowMapper<Calculation> mapCalculationFromDb() {
        return (resultSet, i) ->
                new Calculation(
                        resultSet.getInt("id"),
                        resultSet.getInt("solutionId"),
                        resultSet.getString("expression"),
                        resultSet.getString("comment")
                );
    }

    public List<Calculation> getCalculationById(int id) {
            String sql = "" +
                    "SELECT " +
                    " id, " +
                    " solutionId, " +
                    " expression, " +
                    " comment " +
                    " FROM calculation " +
                    " WHERE id = ?";
            return jdbcTemplate.query(sql, mapCalculationFromDb(), id);
    }

    public List<Calculation> getCalculationsBySolution(int solutionId) {
        String sql = "" +
                "SELECT " +
                " id, " +
                " solutionId, " +
                " expression, " +
                " comment " +
                " FROM calculation " +
                " WHERE solutionId = ?";
        return jdbcTemplate.query(sql, mapCalculationFromDb(), solutionId);
    }

    public int deleteCalculationById(int id) {
        String sql = "" +
                "DELETE FROM calculation " +
                "WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    public int updateCalculationById(Calculation calculation) {
        String sql = "" +
                "UPDATE calculation " +
                "SET solutionId = ? " +
                ",expression = ?" +
                ",comment = ?" +
                "WHERE id = ?";
        return jdbcTemplate.update(sql,
                calculation.getSolutionId(),
                calculation.getExpression(),
                calculation.getComment(),
                calculation.getId()
        );
    }

    public int addCalculation(Calculation calculation) {
        String sql = "" +
                "INSERT INTO calculation (" +
                " solutionId, " +
                " expression, " +
                " comment) " +
                "VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql,
                calculation.getSolutionId(),
                calculation.getExpression(),
                calculation.getComment()
        );
    }
}
