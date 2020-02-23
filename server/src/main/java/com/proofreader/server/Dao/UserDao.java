package com.proofreader.server.Dao;

import com.proofreader.server.Entity.Assignment;
import com.proofreader.server.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> getAllUsers(){
        String sql = "" +
                "SELECT " +
                " id, " +
                " classId, " +
                " username, " +
                " password, " +
                " role " +
                "FROM users" ;

        return jdbcTemplate.query(sql, mapUserFromDb());
    }

    private RowMapper<User> mapUserFromDb() {
        return (resultSet, i) ->
                new User(
                        resultSet.getInt("id"),
                        resultSet.getInt("classId"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("role")
                );
    }

    public List<User> getUserById(int id) {
        String sql = "" +
                "SELECT " +
                " id, " +
                " classId, " +
                " username, " +
                " password, " +
                " role " +
                " FROM users " +
                " WHERE id = ?";
        return jdbcTemplate.query(sql, mapUserFromDb(), id);
    }

    public List<User> getUsername(String name) {
        String sql = "" +
                "SELECT " +
                " id, " +
                " classId, " +
                " username, " +
                " password, " +
                " role " +
                " FROM users " +
                " WHERE username = ?";
        return jdbcTemplate.query(sql, mapUserFromDb(), name);
    }

    public List<User> getUserByCred(String username, String password) {
        String sql = "" +
                "SELECT " +
                " id, " +
                " classId, " +
                " username, " +
                " password, " +
                " role " +
                " FROM users " +
                " WHERE username = ? " +
                "AND password = ?";
        return jdbcTemplate.query(sql, mapUserFromDb(), username, password);
    }

    public int deleteUserById(int id) {
        String sql = "" +
                "DELETE FROM users " +
                "WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    public int updateUserById(User user) {
        String sql = "" +
                "UPDATE users " +
                "SET classId = ? " +
                ",username = ?" +
                ",password = ?" +
                ",role = ?" +
                "WHERE id = ?";
        return jdbcTemplate.update(sql,
                user.getClassId(),
                user.getUsername(),
                user.getPassword(),
                user.getRole(),
                user.getId()
        );
    }

    public int addUser(User user) {
        String sql = "" +
                "INSERT INTO users (" +
                " classId, " +
                " username, " +
                " password, " +
                " role) " +
                "VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                user.getClassId(),
                user.getUsername(),
                user.getPassword(),
                user.getRole()
        );
    }
}
