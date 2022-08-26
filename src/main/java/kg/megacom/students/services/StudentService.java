package kg.megacom.students.services;

import kg.megacom.students.models.Student;
import kg.megacom.students.models.dto.StudentDTO;

import java.util.List;

public interface StudentService {

  StudentDTO createStudent(Student student);

  List<StudentDTO> findAll();

  Student update(Long id, String title);

  Student delete(Long id);

  List<Student> findAllNotDeleted();

  Student findById(Long id);
}
