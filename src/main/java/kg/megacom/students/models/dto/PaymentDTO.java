package kg.megacom.students.models.dto;

import kg.megacom.students.models.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {

    private Long id;
    private Date paymentDate;
    private GroupDTO group;
    private StudentDTO student;
    private PaymentStatus status;
}
