package tr.ogu.edu.school.schoolapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tr.ogu.edu.school.schoolapp.enums.SeatStatus;
import tr.ogu.edu.school.schoolapp.model.ActSessionHallSeat;
import tr.ogu.edu.school.schoolapp.repository.ActSessionHallSeatRepository;

@Service
@RequiredArgsConstructor
public class ActSessionHallService {

	private final ActSessionHallSeatRepository actSessionHallRepository;

	public List<ActSessionHallSeat> getSeatsByHallId(Long sessionId) {
		return actSessionHallRepository.findAllByActSessionInfoId(sessionId);
	}

	public List<ActSessionHallSeat> getSeats() {
		return actSessionHallRepository.findAll();
	}

	public ActSessionHallSeat getSeatById(Long seatId) {
		return actSessionHallRepository.findAllByActSeatId(seatId);
	}

	public ActSessionHallSeat updateSeatStatus(Long seatId) {
		ActSessionHallSeat seatToUpdate = actSessionHallRepository.findAllByActSeatId(seatId);

		if (seatToUpdate != null) {
			seatToUpdate.setStatus(SeatStatus.BLOCKED);
			// Optionally update other fields

			return actSessionHallRepository.save(seatToUpdate);
		} else {
			return null; // Or throw an exception or handle as per your application's logic
		}
	}

}
