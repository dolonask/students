package kg.megacom.students.services;

import kg.megacom.students.models.Group;
import kg.megacom.students.models.Lesson;

import java.util.List;

public interface LessonService {

    List<Lesson> findLessonsByGroup(Group group);

}
