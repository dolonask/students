package kg.megacom.students.models.dto;

import kg.megacom.students.models.enums.StudentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentGroupsDTO {

    private Long id;
    private StudentDTO student;
    private GroupDTO group;
    private Date startDate;
    private Date endDate;
    private StudentStatus status;


}
