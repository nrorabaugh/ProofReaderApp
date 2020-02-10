package com.proofreader.server.Controller;

import com.proofreader.server.Entity.Message;
import com.proofreader.server.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Message> getAllMessage() {
        return messageService.getAllMessages();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public List<Message> getMessageById(@PathVariable("id") int id) {
        return messageService.getMessageById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteMessageById(@PathVariable("id") int id) {
        messageService.deleteMessageById(id);
    }

    @RequestMapping(value = "/assignment/{assId}", method = RequestMethod.GET)
    public List<Message> getMessagesByAssignment(@PathVariable("assId") int assignmentId) {
        return messageService.getMessagesByAssignment(assignmentId);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateMessageById(@RequestBody Message message) {
        messageService.updateMessageById(message);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addMessage(@RequestBody Message message){
        messageService.addMessage(message);
    }
}
