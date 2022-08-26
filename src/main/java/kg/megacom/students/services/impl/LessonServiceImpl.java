package kg.megacom.students.services.impl;

import kg.megacom.students.models.Group;
import kg.megacom.students.models.Lesson;
import kg.megacom.students.repositories.LessonRepo;
import kg.megacom.students.services.LessonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {


    private final LessonRepo lessonRepo;

    public LessonServiceImpl(LessonRepo lessonRepo) {
        this.lessonRepo = lessonRepo;
    }

    @Override
    public List<Lesson> findLessonsByGroup(Group group) {
        return lessonRepo.findAllByGroupOrderById(group);
    }
}
