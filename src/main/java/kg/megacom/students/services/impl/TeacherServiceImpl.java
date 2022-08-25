package kg.megacom.students.services.impl;

import kg.megacom.students.models.Teacher;
import kg.megacom.students.repositories.TeacherRepo;
import kg.megacom.students.services.TeacherService;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepo teacherRepo;

    public TeacherServiceImpl(TeacherRepo teacherRepo) {
        this.teacherRepo = teacherRepo;
    }

    @Override
    public Teacher createTeacher(Teacher teacher) {
//        Teacher newTeacher = new Teacher();
//        newTeacher.setName(teacher.getName());
//        newTeacher.setSurname(teacher.getSurname());
        return teacherRepo.save(teacher);
    }
    }
