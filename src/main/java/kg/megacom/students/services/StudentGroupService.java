package kg.megacom.students.services;

import kg.megacom.students.models.StudentGroups;
import org.springframework.http.ResponseEntity;

import java.util.Date;

public interface StudentGroupService {
    ResponseEntity create(Date startDate, Date endDate, Long studentId, Long groupId);
}
