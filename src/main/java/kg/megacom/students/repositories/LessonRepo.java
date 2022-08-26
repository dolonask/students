package kg.megacom.students.repositories;

import kg.megacom.students.models.Group;
import kg.megacom.students.models.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LessonRepo extends JpaRepository<Lesson, Long> {

    List<Lesson> findAllByGroupOrderById(Group group);

}
