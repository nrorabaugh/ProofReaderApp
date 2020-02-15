package com.proofreader.server.Service;

import com.proofreader.server.Dao.ClassroomDao;
import com.proofreader.server.Entity.Classroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ClassroomService {

    @Autowired
    private ClassroomDao dao;

    public List<Classroom> getAllClassrooms() {
        return this.dao.getAllClassrooms();
    }

    public List<Classroom> getClassroomById(int id) {
        return this.dao.getClassroomById(id);
    }

    public List<Classroom> getClassroomByTeacher(int id) { return this.dao.getClassroomByTeacher(id); }

    public void deleteClassroomById(int id) {
        this.dao.deleteClassroomById(id);
    }

    public void updateClassroomById(Classroom classroom) {
        this.dao.updateClassroomById(classroom);
    }

    public void addClassroom(Classroom classroom) {
        this.dao.addClassroom(classroom);
    }
}

