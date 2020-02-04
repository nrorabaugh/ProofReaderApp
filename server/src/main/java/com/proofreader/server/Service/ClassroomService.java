package com.proofreader.server.Service;

import com.proofreader.server.Dao.ClassroomDao;
import com.proofreader.server.Entity.Classroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ClassroomService {

    @Autowired
    private ClassroomDao dao;

    public Collection<Classroom> getAllMessages() {
        return this.dao.getAllClassrooms();
    }

    public Classroom getMessageById(int id) {
        return this.dao.getClassroomById(id);
    }

    public void deleteMessageById(int id) {
        this.dao.deleteClassroomById(id);
    }

    public void updateMessageById(Classroom classroom) {
        this.dao.updateClassroomById(classroom);
    }

    public void addMessage(Classroom classroom) {
        this.dao.addClassroom(classroom);
    }
}

