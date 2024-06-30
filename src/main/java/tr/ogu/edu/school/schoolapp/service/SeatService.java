package tr.ogu.edu.school.schoolapp.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import tr.ogu.edu.school.schoolapp.model.ActSeat;
import tr.ogu.edu.school.schoolapp.repository.SeatsRepository;

@Slf4j
@Service
@AllArgsConstructor
public class SeatService {
    private SeatsRepository seatsRepository;
    public List<ActSeat> getAllSeats() {
        return seatsRepository.findAll();
    }
}

