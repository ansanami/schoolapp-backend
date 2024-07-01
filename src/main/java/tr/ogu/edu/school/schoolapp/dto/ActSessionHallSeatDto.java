package tr.ogu.edu.school.schoolapp.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;
import tr.ogu.edu.school.schoolapp.enums.SeatStatus;

@Data
public class ActSessionHallSeatDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private Date blockedTime;

	private SeatStatus status;

	private ActSeatDto actSeat;

	private ActSessionInfoDto actSessionInfo;

	private UserDto user;

	private List<ActTicketDto> actTickets;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getBlockedTime() {
		return blockedTime;
	}

	public void setBlockedTime(Date blockedTime) {
		this.blockedTime = blockedTime;
	}

	public SeatStatus getStatus() {
		return status;
	}

	public void setStatus(SeatStatus status) {
		this.status = status;
	}

	public ActSeatDto getActSeat() {
		return actSeat;
	}

	public void setActSeat(ActSeatDto actSeat) {
		this.actSeat = actSeat;
	}

	public ActSessionInfoDto getActSessionInfo() {
		return actSessionInfo;
	}

	public void setActSessionInfo(ActSessionInfoDto actSessionInfo) {
		this.actSessionInfo = actSessionInfo;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public List<ActTicketDto> getActTickets() {
		return actTickets;
	}

	public void setActTickets(List<ActTicketDto> actTickets) {
		this.actTickets = actTickets;
	}
}