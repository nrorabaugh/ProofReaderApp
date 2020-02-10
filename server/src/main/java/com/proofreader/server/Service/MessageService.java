package com.proofreader.server.Service;

import com.proofreader.server.Dao.MessageDao;
import com.proofreader.server.Entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageDao dao;

    public List<Message> getAllMessages() {
        return this.dao.getAllMessages();
    }

    public List<Message> getMessagesByAssignment(int assignmentId) { return this.dao.getMessageByAssignment(assignmentId); }

    public List<Message> getMessageById(int id) {
        return this.dao.getMessageById(id);
    }

    public void deleteMessageById(int id) {
        this.dao.deleteMessageById(id);
    }

    public void updateMessageById(Message message) {
        this.dao.updateMessageById(message);
    }

    public void addMessage(Message message) {
        this.dao.addMessage(message);
    }
}
