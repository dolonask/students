package kg.megacom.students.services.impl;

import kg.megacom.students.models.Group;
import kg.megacom.students.models.Payment;
import kg.megacom.students.models.Student;
import kg.megacom.students.models.StudentGroups;
import kg.megacom.students.models.enums.StudentStatus;
import kg.megacom.students.repositories.StudentGroupsRepo;
import kg.megacom.students.services.GroupService;
import kg.megacom.students.services.PaymentService;
import kg.megacom.students.services.StudentGroupService;
import kg.megacom.students.services.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StudentGroupServiceImpl implements StudentGroupService {
    //private final StudentRepo studentRepo;
    private final StudentService studentService;
    private final GroupService groupService;
    private final StudentGroupsRepo studentGroupsRepo;
    private final PaymentService paymentService;

    public StudentGroupServiceImpl(StudentService studentService, GroupService groupService, StudentGroupsRepo studentGroupsRepo, PaymentService paymentService) {
        this.studentService = studentService;
        this.groupService = groupService;
        this.studentGroupsRepo = studentGroupsRepo;
        this.paymentService = paymentService;
    }


    @Override
    public ResponseEntity create(Date startDate, Date endDate,
                                Long studentId, Long groupId) {
//        try {
//            Student student = studentRepo.findById(studentId).get();
//        if(student.isDeleted()){
//            return ResponseEntity.ok("Student is deleted");
//        }
//        StudentGroups studentGroups = new StudentGroups();
//        studentGroups.setStudent(student);
//        studentGroups.setGroup(groupRepo.findById(groupId).get());
//        studentGroups.setStartDate(startDate);
//        studentGroups.setEndDate(endDate);
//        studentGroups.setStatus(StudentStatus.STUDIES);
//        return ResponseEntity.ok(studentGroupsRepo.save(studentGroups));
//        } catch(Exception e){
//            return ResponseEntity.ok("Student doesn't exists");
//        }

        return  null;
    }

    @Override
    public StudentGroups append(Long studentId, Long groupId) {

        Student student = studentService.findById(studentId);
        Group group = groupService.findById(groupId);

        student.setName("sdjfnks");


        if (group.getEndDate().compareTo(new Date()) <= 0)
            throw new RuntimeException("Группа уже завершила обучение!");

        StudentGroups studentGroups = studentGroupsRepo.findByStudentAndGroup(student, group);

        if (studentGroups == null){
            // студент новый. Надо создать
            studentGroups = new StudentGroups();
            studentGroups.setStatus(StudentStatus.STUDIES);
            studentGroups.setStartDate(new Date());
            studentGroups.setGroup(group);
            studentGroups.setStudent(student);

            studentGroups = studentGroupsRepo.save(studentGroups);
            List<Payment> payments = paymentService.setPayments(student, group);

            System.out.println(payments);




        }else {
            if (studentGroups.getStatus().equals(StudentStatus.STUDIES))
                throw new RuntimeException("Студент уже в группе!");
            else {
                studentGroups.setStatus(StudentStatus.STUDIES);
                studentGroupsRepo.save(studentGroups);
            }
        }



        return studentGroups;
    }
}
