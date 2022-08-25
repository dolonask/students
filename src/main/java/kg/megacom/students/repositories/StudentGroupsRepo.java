package kg.megacom.students.repositories;

import kg.megacom.students.models.StudentGroups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentGroupsRepo extends JpaRepository<StudentGroups, Long> {
}
