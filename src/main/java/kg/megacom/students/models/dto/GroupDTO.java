package kg.megacom.students.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupDTO {

    private Long id;
    private String name;
    private Date startDate;
    private Date endDate;
    private CourseDTO course;
    private TeacherDTO teacher;

}
