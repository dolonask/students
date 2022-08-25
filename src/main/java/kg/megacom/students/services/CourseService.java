package kg.megacom.students.services;

import kg.megacom.students.models.Course;

public interface CourseService {

    Course createCourse(Course course);

    Course findById(Long id);

}
