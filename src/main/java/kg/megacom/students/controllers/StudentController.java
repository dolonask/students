package kg.megacom.students.controllers;

import kg.megacom.students.models.Student;
import kg.megacom.students.models.dto.StudentDTO;
import kg.megacom.students.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/createStudent")
    public StudentDTO createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }
    @GetMapping("/findAll")
    public List<StudentDTO>findAll(){return studentService.findAll();}

    @PutMapping("/updadte")
    public Student updateStudent(@RequestParam Long id, @RequestParam String title){
        return studentService.update(id, title);
    }

    @DeleteMapping("/delete")
    Student delete(@RequestParam Long id){
        return studentService.delete(id);
    }

    @GetMapping("/findAllNotDeleted")
    public List<Student>findAllNotDeleted(){return studentService.findAllNotDeleted();}
}
