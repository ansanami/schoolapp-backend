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

	@PutMapping("/{seatId}/{Id}")
	public ResponseEntity<ActSessionHallSeatDto> updateSeatStatus(@PathVariable Long seatId,@PathVariable Long Id) {
		ActSessionHallSeat actSessionHallSeat = actSessionHallService.updateSeatStatus(seatId,Id);
		if (actSessionHallSeat != null) {
			ActSessionHallSeatDto updatedSeatDto = ActSessionHallMapper.INSTANCE.toDto(actSessionHallSeat);
			return ResponseEntity.ok(updatedSeatDto);
		} else {
			// Handle case where seat was not found
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping("/tickets/{userId}")
	public ResponseEntity<List<ActSessionHallSeatDto>> getSeatsByUserId(@PathVariable Long userId) {
		List<ActSessionHallSeat> seats = actSessionHallService.getSeatsByUserId(userId);
		List<ActSessionHallSeatDto> seatDtos = ActSessionHallMapper.INSTANCE.toDtoList(seats);
		return ResponseEntity.ok(seatDtos);
	}

}
