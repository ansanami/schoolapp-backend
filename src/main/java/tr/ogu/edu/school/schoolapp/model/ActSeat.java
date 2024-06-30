package tr.ogu.edu.school.schoolapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "act_seat")
public class ActSeat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String line;
	private Integer no;

	@ManyToOne
	@JoinColumn(name = "hall_id")
	private ActHall actHall;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private ActCategory actCategory;

	@OneToMany(mappedBy = "actSeat")
	private List<ActSessionHallSeat> actSessionHalls;

	// Constructors, getters, setters, and other methods as needed
}
