package com.proofreader.server.Controller;

import com.proofreader.server.Entity.Classroom;
import com.proofreader.server.Service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/classrooms")
public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Classroom> getAllMessage() {
        return classroomService.getAllMessages();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Classroom getClassroomById(@PathVariable("id") int id) {
        return classroomService.getMessageById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteClassroomById(@PathVariable("id") int id) {
        classroomService.deleteMessageById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateClassroomById(@RequestBody Classroom classroom) {
        classroomService.updateMessageById(classroom);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addClassroom(@RequestBody Classroom classroom){
        classroomService.addMessage(classroom);
    }
}
