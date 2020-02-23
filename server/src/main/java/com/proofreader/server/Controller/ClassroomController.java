
package com.proofreader.server.Controller;

import com.proofreader.server.Entity.Classroom;
import com.proofreader.server.Service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/classrooms")
public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Classroom> getAllClassrooms() {
        return classroomService.getAllClassrooms();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public List<Classroom> getClassroomById(@PathVariable("id") int id) {
        return classroomService.getClassroomById(id);
    }

    @RequestMapping(value="/teacher/{id}", method = RequestMethod.GET)
    public List<Classroom> getClassroomByTeacher(@PathVariable("id") int id) {
        return classroomService.getClassroomByTeacher(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteClassroomById(@PathVariable("id") int id) {
        classroomService.deleteClassroomById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateClassroomById(@RequestBody Classroom classroom) {
        classroomService.updateClassroomById(classroom);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addClassroom(@RequestBody Classroom classroom){
        classroomService.addClassroom(classroom);
    }
}
