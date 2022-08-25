package kg.megacom.students.services.impl;

import kg.megacom.students.models.Course;
import kg.megacom.students.repositories.CourseRepo;
import kg.megacom.students.services.CourseService;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepo courseRepo;

    public CourseServiceImpl(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    @Override
    public Course createCourse(Course course) {
        return courseRepo.save(course);
    }

    @Override
    public Course findById(Long id) {
        return courseRepo.findById(id).orElseThrow();
    }
}
