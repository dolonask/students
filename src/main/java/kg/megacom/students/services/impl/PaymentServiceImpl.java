package kg.megacom.students.services.impl;

import kg.megacom.students.models.Group;
import kg.megacom.students.models.Lesson;
import kg.megacom.students.models.Payment;
import kg.megacom.students.models.Student;
import kg.megacom.students.models.enums.PaymentStatus;
import kg.megacom.students.repositories.PaymentRepo;
import kg.megacom.students.services.LessonService;
import kg.megacom.students.services.PaymentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepo paymentRepo;
    private final LessonService lessonService;

    public PaymentServiceImpl(PaymentRepo paymentRepo, LessonService lessonService) {
        this.paymentRepo = paymentRepo;
        this.lessonService = lessonService;
    }

    @Override
    public List<Payment> setPayments(Student student, Group group) {
        List<Lesson> lessons = lessonService.findLessonsByGroup(group);
        List<Payment> payments = new ArrayList<>();

        for (int i = 0; i < lessons.size(); i++){
            if (i % group.getCourse().getPeriod() == 0){
                Payment payment = new Payment();
                payment.setStudent(student);
                payment.setGroup(group);
                payment.setPaymentDate(lessons.get(i).getDay());
                payment.setStatus(PaymentStatus.UNPAID);

                payments.add(payment);
            }
        }

        payments = paymentRepo.saveAll(payments);
        return payments;
        // 12
        // 4
        // 0 1 2 3 4 5 6 7 8 9 10 11
        // 0 4 8

        // 3
        // 0 1 2 3 4 5 6 7 8 9 10 11
        // 0 3 6 9

    }
}
