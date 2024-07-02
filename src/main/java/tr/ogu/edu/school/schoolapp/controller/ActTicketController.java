package tr.ogu.edu.school.schoolapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import tr.ogu.edu.school.schoolapp.dto.ActTicketDto;
import tr.ogu.edu.school.schoolapp.mapper.ActTicketMapper;
import tr.ogu.edu.school.schoolapp.model.ActTicket;
import tr.ogu.edu.school.schoolapp.service.ActTicketService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tickets")
public class ActTicketController {
	private final ActTicketService actTicketService;

	@GetMapping("/{userId}")
	public ResponseEntity<List<ActTicketDto>> getTicketsByUserId(@PathVariable Long userId) {
		List<ActTicket> actTickets = actTicketService.getTicketsByUserId(userId);
		ActTicketMapper actTicketMapper = new ActTicketMapper();
		List<ActTicketDto> actTicketDtos = new ArrayList<>();
		for (ActTicket actTicket : actTickets) {
			actTicketMapper.toDto(actTicket);
			actTicketDtos.add(actTicketMapper.toDto(actTicket));
		}
		return ResponseEntity.ok(actTicketDtos);
	}
}
