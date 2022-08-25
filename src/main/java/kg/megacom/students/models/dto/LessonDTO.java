package kg.megacom.students.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LessonDTO {

    private Long id;
    private Date day;
    private GroupDTO group;
}
