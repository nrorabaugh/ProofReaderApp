package com.proofreader.server.Dao;

import com.proofreader.server.Entity.Message;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MessageDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MessageDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    public static Map<Integer, Message> messages;
//
//    static {
//        messages = new HashMap<Integer, Message>() {
//            {
//                put(1, new Message(1, 1, "Yo", 1, "x^2 + 3x + 7"));
//                put(2, new Message(2, 2, "whats up", 2, "none"));
//                put(3, new Message(3, 2, "u good", 1, "none"));
//                put(4, new Message(4, 1, "my b", 1, "none"));
//            }
//        };
//    }
    public List<Message> getAllMessages(){
        String sql = "" +
                "SELECT " +
                " id, " +
                " senderId, " +
                " content, " +
                " assignmentId, " +
                " eq " +
                "FROM message";

        return jdbcTemplate.query(sql, mapMessageFromDb());
    }

    private RowMapper<Message> mapMessageFromDb() {
        return (resultSet, i) ->
                new Message(
                        resultSet.getInt("id"),
                        resultSet.getInt("senderId"),
                        resultSet.getString("content"),
                        resultSet.getInt("assignmentId"),
                        resultSet.getString("eq")
                        );
    }

    public List<Message> getMessageById(int id) {
        String sql = "" +
                "SELECT " +
                " id, " +
                " senderId, " +
                " assignmentId, " +
                " content, " +
                " eq " +
                " FROM message " +
                " WHERE id = ?";
        return jdbcTemplate.query(sql, mapMessageFromDb(), id);
    }

    public List<Message> getMessageByAssignment(int assignmentId) {
        String sql = "" +
                "SELECT " +
                " id, " +
                " senderId, " +
                " assignmentId, " +
                " content, " +
                " eq " +
                " FROM message" +
                " WHERE assignmentId = ?";

        return jdbcTemplate.query(sql, mapMessageFromDb(), assignmentId);
    }

    public int deleteMessageById(int id) {
        String sql = "" +
                "DELETE FROM message " +
                "WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    public int updateMessageById(Message message) {
        String sql = "" +
                "UPDATE message " +
                "SET senderId = ? " +
                ",assignmentId = ?" +
                ",content = ?" +
                ",eq = ?" +
                "WHERE id = ?";
        return jdbcTemplate.update(sql,
                message.getSenderId(),
                message.getAssignmentId(),
                message.getContent(),
                message.getEq(),
                message.getId()
        );
    }

    public int addMessage(Message message) {
        String sql = "" +
                "INSERT INTO message (" +
                " senderId, " +
                " assignmentId, " +
                " content, " +
                " eq) " +
                "VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(
                sql,
                message.getSenderId(),
                message.getAssignmentId(),
                message.getContent(),
                message.getEq()
        );
    }
}
