package com.proofreader.server.Dao;

import com.proofreader.server.Entity.Message;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@Repository
public class MessageDao {

    public static Map<Integer, Message> messages;

    static {
        messages = new HashMap<Integer, Message>() {
            {
                put(1, new Message(1, 1, "Yo", 1, "x^2 + 3x + 7"));
                put(2, new Message(2, 2, "whats up", 2, "none"));
                put(3, new Message(3, 2, "u good", 1, "none"));
                put(4, new Message(4, 1, "my b", 1, "none"));
            }
        };
    }
    public Collection<Message> getAllMessages() {
        return messages.values();
    }

    public Message getMessageById(int id) {
        return messages.get(id);
    }

    public Collection<Message> getMessageByAssignment(int assignmentId) {
        Collection<Message> messagesRaw = messages.values();
        Collection<Message> messagesParse = new LinkedList<Message>();
        for(Message i : messagesRaw ) {
            if(i.getAssignmentId() == assignmentId) {
                messagesParse.add(i);
            }
        }
        return messagesParse;
    }

    public void deleteMessageById(int id) {
        messages.remove(id);
    }

    public void updateMessageById(Message message) {
        Message messageToUpdate = messages.get(message.getId());
        messageToUpdate.setAssignmentId(message.getAssignmentId());
        messageToUpdate.setSenderId(message.getSenderId());
        messageToUpdate.setContent(message.getContent());
        messageToUpdate.setEq(message.getEq());
        messages.put(message.getId(), message);
    }

    public void addMessage(Message message) {
        messages.put(message.getId(), message);
    }
}
