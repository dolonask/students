package kg.megacom.students.models;

import kg.megacom.students.models.enums.StudentStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity
@Table(name = "student_groups")
public class StudentGroups {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
    private Date startDate;
    private Date endDate;
    @Enumerated(value = EnumType.STRING)
    private StudentStatus status;


}
