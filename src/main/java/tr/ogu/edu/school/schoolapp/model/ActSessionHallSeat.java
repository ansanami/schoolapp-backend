package tr.ogu.edu.school.schoolapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import tr.ogu.edu.school.schoolapp.enums.SeatStatus;

/**
 * The persistent class for the act_session_hall database table.
 * 
 */
@Entity
@Data
@Table(name = "act_session_hall_seat")
public class ActSessionHallSeat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(name = "blocked_time")
	private Date blockedTime;

	@Enumerated(EnumType.STRING)
	private SeatStatus status;

	// bi-directional many-to-one association to ActSeat
	@ManyToOne
	@JoinColumn(name = "seat_id")
	private ActSeat actSeat;

	// bi-directional many-to-one association to ActSessionInfo
	@ManyToOne
	@JoinColumn(name = "session_id")
	private ActSessionInfo actSessionInfo;

	// bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	// bi-directional many-to-one association to ActTicket
	@OneToMany(mappedBy = "actSessionHallSeat")
	private List<ActTicket> actTickets;

	public ActTicket addActTicket(ActTicket actTicket) {
		if (getActTickets() == null) {
			setActTickets(new ArrayList<>());
		}
		getActTickets().add(actTicket);
		actTicket.setActSessionHallSeat(this);

		return actTicket;
	}

	public ActTicket removeActTicket(ActTicket actTicket) {
		getActTickets().remove(actTicket);
		actTicket.setActSessionHallSeat(null);

		return actTicket;
	}

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

	public ActSeat getActSeat() {
		return actSeat;
	}

	public void setActSeat(ActSeat actSeat) {
		this.actSeat = actSeat;
	}

	public ActSessionInfo getActSessionInfo() {
		return actSessionInfo;
	}

	public void setActSessionInfo(ActSessionInfo actSessionInfo) {
		this.actSessionInfo = actSessionInfo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<ActTicket> getActTickets() {
		return actTickets;
	}

	public void setActTickets(List<ActTicket> actTickets) {
		this.actTickets = actTickets;
	}
}