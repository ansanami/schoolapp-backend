package tr.ogu.edu.school.schoolapp.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import tr.ogu.edu.school.schoolapp.dto.ActSeatDto;
import tr.ogu.edu.school.schoolapp.model.ActSeat;
import tr.ogu.edu.school.schoolapp.service.SeatService;
import tr.ogu.edu.school.schoolapp.mapper.ActSeatMapper;

@RestController
@RequestMapping(value = "/seats")
@RequiredArgsConstructor
public class SeatController {

    private final SeatService seatService;

    @GetMapping()
    public ResponseEntity<List<ActSeatDto>> getSeats() {
        try {
            List<ActSeat> seats = seatService.getAllSeats();
            List<ActSeatDto> seatDtos = seats.stream().map(ActSeatMapper.INSTANCE::toDto).collect(Collectors.toList());
            return ResponseEntity.ok(seatDtos);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }
}
