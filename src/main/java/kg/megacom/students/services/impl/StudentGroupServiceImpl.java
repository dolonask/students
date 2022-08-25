package kg.megacom.students.services.impl;

import kg.megacom.students.models.Student;
import kg.megacom.students.models.StudentGroups;
import kg.megacom.students.models.enums.StudentStatus;
import kg.megacom.students.repositories.GroupRepo;
import kg.megacom.students.repositories.StudentGroupsRepo;
import kg.megacom.students.repositories.StudentRepo;
import kg.megacom.students.services.StudentGroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

@Service
public class StudentGroupServiceImpl implements StudentGroupService {
    private final StudentRepo studentRepo;
    private final GroupRepo groupRepo;
    private final StudentGroupsRepo studentGroupsRepo;

    public StudentGroupServiceImpl(StudentRepo studentRepo, GroupRepo groupRepo, StudentGroupsRepo studentGroupsRepo) {
        this.studentRepo = studentRepo;
        this.groupRepo = groupRepo;
        this.studentGroupsRepo = studentGroupsRepo;
    }


    @Override
    public ResponseEntity create(Date startDate, Date endDate,
                                Long studentId, Long groupId) {
        try {
            Student student = studentRepo.findById(studentId).get();
        if(student.isDeleted()){
            return ResponseEntity.ok("Student is deleted");
        }
        StudentGroups studentGroups = new StudentGroups();
        studentGroups.setStudent(student);
        studentGroups.setGroup(groupRepo.findById(groupId).get());
        studentGroups.setStartDate(startDate);
        studentGroups.setEndDate(endDate);
        studentGroups.setStatus(StudentStatus.STUDIES);
        return ResponseEntity.ok(studentGroupsRepo.save(studentGroups));
        } catch(Exception e){
            return ResponseEntity.ok("Student doesn't exists");
        }
    }
}
