package com.proofreader.server.Dao;

import com.proofreader.server.Entity.Classroom;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ClassroomDao {

    public static Map<Integer, Classroom> classrooms;

    static {
        classrooms = new HashMap<Integer, Classroom>() {
            {
                put(1, new Classroom(1, "Class1", 1));
                put(2, new Classroom(2,"Class2", 1));
                put(3, new Classroom(3, "Class3", 1));
                put(4, new Classroom(4, "Class4", 1));
            }
        };
    }
    public Collection<Classroom> getAllClassrooms() {
        return this.classrooms.values();
    }

    public Classroom getClassroomById(int id) {
        return this.classrooms.get(id);
    }

    public void deleteClassroomById(int id) {
        this.classrooms.remove(id);
    }

    public void updateClassroomById(Classroom classroom) {
        Classroom classToUpdate = classrooms.get(classroom.getId());
        classToUpdate.setTeacherId(classroom.getTeacherId());
        classToUpdate.setName(classroom.getName());
        classrooms.put(classroom.getId(), classroom);
    }

    public void addClassroom(Classroom classroom) {
        classrooms.put(classroom.getId(), classroom);
    }
}
