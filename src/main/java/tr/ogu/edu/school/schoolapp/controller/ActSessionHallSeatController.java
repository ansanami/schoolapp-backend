package tr.ogu.edu.school.schoolapp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import tr.ogu.edu.school.schoolapp.dto.ActSessionHallSeatDto;
import tr.ogu.edu.school.schoolapp.mapper.ActSessionHallMapper;
import tr.ogu.edu.school.schoolapp.model.ActSessionHallSeat;
import tr.ogu.edu.school.schoolapp.service.ActSessionHallService;

@RestController
@RequestMapping(value = "/session-seats")
@RequiredArgsConstructor
public class ActSessionHallSeatController {

	private final ActSessionHallService actSessionHallService;

	@GetMapping("/{sessionId}")
	public ResponseEntity<List<ActSessionHallSeatDto>> getSessionSeats(@PathVariable Long sessionId) {
		List<ActSessionHallSeat> seats = actSessionHallService.getSeatsByHallId(sessionId);
		List<ActSessionHallSeatDto> seatDtos = ActSessionHallMapper.INSTANCE.toDtoList(seats);
		return ResponseEntity.ok(seatDtos);
	}

	@PutMapping("/{seatId}")
	public ResponseEntity<ActSessionHallSeatDto> updateSeatStatus(@PathVariable Long seatId, @RequestBody String UserId) {
		ActSessionHallSeat actSessionHallSeat = actSessionHallService.updateSeatStatus(seatId,UserId);
		if (actSessionHallSeat != null) {
			ActSessionHallSeatDto updatedSeatDto = ActSessionHallMapper.INSTANCE.toDto(actSessionHallSeat);
			return ResponseEntity.ok(updatedSeatDto);
		} else {
			// Handle case where seat was not found
			return ResponseEntity.notFound().build();
		}
	}

}
