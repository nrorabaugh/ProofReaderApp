package com.proofreader.server.Dao;

import com.proofreader.server.Entity.Assignment;
import com.proofreader.server.Entity.Classroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;


@Repository
public class ClassroomDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ClassroomDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Classroom> getAllClassrooms() {
        String sql = "" +
                "SELECT " +
                " id, " +
                " teacherId, " +
                " name " +
                "FROM classroom" ;

        return jdbcTemplate.query(sql, mapClassroomFromDb());
    }

    private RowMapper<Classroom> mapClassroomFromDb() {
        return (resultSet, i) ->
                new Classroom(
                        resultSet.getInt("id"),
                        resultSet.getInt("teacherId"),
                        resultSet.getString("name")
                );
    }

    public List<Classroom> getClassroomById(int id) {
        String sql = "" +
                "SELECT " +
                " id, " +
                " teacherId, " +
                " name " +
                " FROM classroom " +
                " WHERE id = ?";
        return jdbcTemplate.query(sql, mapClassroomFromDb(), id);
    }

    public List<Classroom> getClassroomByTeacher(int teacherId) {
        String sql = "" +
                "SELECT " +
                " id, " +
                " teacherId, " +
                " name " +
                " FROM classroom " +
                " WHERE teacherId = ?";
        return jdbcTemplate.query(sql, mapClassroomFromDb(), teacherId);
    }

    public int deleteClassroomById(int id) {
        String sql = "" +
                "DELETE FROM classroom " +
                "WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    public int updateClassroomById(Classroom classroom) {
        String sql = "" +
                "UPDATE classroom " +
                "SET teacherId = ? " +
                ",name = ?" +
                "WHERE id = ?";
        return jdbcTemplate.update(sql,
                classroom.getTeacherId(),
                classroom.getName(),
                classroom.getId()
        );
    }

    public int addClassroom(Classroom classroom) {
        String sql = "" +
                "INSERT INTO classroom (" +
                " teacherId, " +
                " name) " +
                "VALUES (?, ?)";
        return jdbcTemplate.update(sql,
                classroom.getTeacherId(),
                classroom.getName()
        );
    }
}
