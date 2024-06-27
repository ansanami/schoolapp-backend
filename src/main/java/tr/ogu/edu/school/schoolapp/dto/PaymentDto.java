package tr.ogu.edu.school.schoolapp.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentDto {
	private Long id;
	private Double amount;
	private Date paymentDate;
}
