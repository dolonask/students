package kg.megacom.students.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDTO {
    private Long id;
    private String name;
    private String surname;
    private String title;
}
