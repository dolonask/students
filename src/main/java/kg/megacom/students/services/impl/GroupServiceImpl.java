package kg.megacom.students.services.impl;

import kg.megacom.students.models.Course;
import kg.megacom.students.models.Group;
import kg.megacom.students.models.Lesson;
import kg.megacom.students.models.enums.Day;
import kg.megacom.students.models.requests.GroupRequest;
import kg.megacom.students.repositories.GroupRepo;
import kg.megacom.students.repositories.LessonRepo;
import kg.megacom.students.services.CourseService;
import kg.megacom.students.services.GroupService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupServiceImpl implements GroupService {

    private final GroupRepo groupRepo;
    private final CourseService courseService;
    private final LessonRepo lessonRepo;


    public GroupServiceImpl(GroupRepo groupRepo, CourseService courseService, LessonRepo lessonRepo) {
        this.groupRepo = groupRepo;
        this.courseService = courseService;
        this.lessonRepo = lessonRepo;
    }

    @Override
    public Group createGroup(Group group) {
        return groupRepo.save(group);
    }

    private List<Date> getLessonsDates(List<Day> days, int duration, Date startDate){
        List<Date> dates = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);

        //days=[MONDAY, WEDNESDAY, FRIDAY]
        // [2, 4, 6]
        // []

        for (int i = 0; i < duration; ){

            long count = days
                    .stream()
                    .map(x->x.getDayValue())
                    .filter(x-> x == calendar.get(Calendar.DAY_OF_WEEK))
                    .count();

            if (count == 1) {
                i++;
                dates.add(calendar.getTime());
            }

            calendar.add(Calendar.DAY_OF_MONTH, 1);

        }

        return dates;

    }

    @Override
    public Group create(GroupRequest groupRequest) {
        //GroupRequest(groupTitle=Java 18:00, courseId=1, startDate=Thu Sep 01 06:00:00 ALMT 2022, days=[MONDAY, WEDNESDAY, FRIDAY])

        // Найти курс по ID
        // duration не должен быть пустой или меньше или равно 0
        // Получить список дат уроков
        // insert into groups
        // insert into lessons

        Course course = courseService.findById(groupRequest.getCourseId());
        System.out.println(course);

        if (course.getDuration() <= 0)
            throw new RuntimeException("Длительность не может быть меньше или равна нулю!");

        List<Date> lessonsDates = getLessonsDates(groupRequest.getDays(), course.getDuration(), groupRequest.getStartDate());

        Date maxDate = lessonsDates
                .stream()
                .max(Date::compareTo)
                .get();


        Group group = new Group();
        group.setCourse(course);
        group.setStartDate(groupRequest.getStartDate());
        group.setEndDate(maxDate);
        group.setName(groupRequest.getGroupTitle());

        group = groupRepo.save(group);

        Group finalGroup = group;

        List<Lesson> lessons = lessonsDates
                .stream()
                .map(x-> {
                    Lesson lesson = new Lesson();
                    lesson.setDay(x);
                    lesson.setGroup(finalGroup);
                    return lesson;
                })
                .collect(Collectors.toList());

        lessonRepo.saveAll(lessons);



        return group;
    }
}
