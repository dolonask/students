package kg.megacom.students.services.impl;

import kg.megacom.students.mappers.StudentMapper;
import kg.megacom.students.models.Student;
import kg.megacom.students.models.dto.StudentDTO;
import kg.megacom.students.repositories.StudentRepo;
import kg.megacom.students.services.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;

   private final StudentMapper studentMapper;
    public StudentServiceImpl(StudentRepo studentRepo, StudentMapper studentMapper) {
        this.studentRepo = studentRepo;
        this.studentMapper = studentMapper;
    }

    @Override
    public StudentDTO createStudent(Student student) {
//        Student newStudent = new Student();
//        newStudent.setId(student.getId());
//        newStudent.setName(student.getName());
//        newStudent.setSurname(student.getSurname());
//        newStudent.setTitle(student.getTitle());
        studentRepo.save(student);
    return studentMapper.toDTO(student);
    }

    @Override
    public List<StudentDTO> findAll() {
        List<Student> studentList = studentRepo.findAll();

        return studentMapper.toDTOList(studentList);
    }

    @Override
    public Student update(Long id, String title) {
//     Optional<Student> student = studentRepo.findById(id);
//     student.get().setTitle(title);
        studentRepo.update(id, title);

        return studentRepo.findById(id).get();
    }

    @Override
    public Student delete(Long id) {
//        studentRepo.delete(studentRepo.findById(id).get());
        Student student = studentRepo.findById(id).get();
        student.setDeleted(true);
       studentRepo.save(student);
        return studentRepo.findById(id).get();

    }

    @Override
    public List<Student> findAllNotDeleted() {
        return studentRepo.findAllByIsDeletedIsFalse();
    }


}
