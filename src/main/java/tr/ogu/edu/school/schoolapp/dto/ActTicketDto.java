package tr.ogu.edu.school.schoolapp.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ActTicketDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String filepath;

	private Date sessionDate;

	private String status;

	private String verificationCode;

	private ActSessionHallSeatDto actSessionHall;

	private UserDto user;

}