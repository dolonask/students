package kg.megacom.students.mappers;

import kg.megacom.students.models.Student;
import kg.megacom.students.models.dto.StudentDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class StudentMapper {
    private final ModelMapper modelMapper;

    public Student toEntity(StudentDTO studentDTO){
        return Objects.isNull(studentDTO) ? null : modelMapper.map(studentDTO,Student.class);
    }

    public StudentDTO toDTO(Student student){
        return Objects.isNull(student) ? null : modelMapper.map(student,StudentDTO.class);
    }

    public List<StudentDTO> toDTOList(List<Student> studentList){
    return studentList.stream()
                .map(student -> modelMapper.map(student, StudentDTO.class))
                .collect(Collectors.toList());
    }

}
