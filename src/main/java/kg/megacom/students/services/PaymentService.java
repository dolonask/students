package kg.megacom.students.services;

import kg.megacom.students.models.Group;
import kg.megacom.students.models.Payment;
import kg.megacom.students.models.Student;

import java.util.List;

public interface PaymentService {

    List<Payment> setPayments(Student student, Group group);

}
