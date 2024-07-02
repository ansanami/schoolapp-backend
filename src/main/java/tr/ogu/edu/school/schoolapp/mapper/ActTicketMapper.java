package tr.ogu.edu.school.schoolapp.mapper;

import org.springframework.stereotype.Component;
import tr.ogu.edu.school.schoolapp.dto.ActSessionHallSeatDto;
import tr.ogu.edu.school.schoolapp.dto.ActTicketDto;
import tr.ogu.edu.school.schoolapp.mapper.ActSessionHallMapper;
import tr.ogu.edu.school.schoolapp.mapper.UserMapper;
import tr.ogu.edu.school.schoolapp.model.ActSessionHallSeat;
import tr.ogu.edu.school.schoolapp.model.ActTicket;

@Component
public class ActTicketMapper {
    public ActTicketDto toDto(ActTicket actTicket) {
        ActTicketDto dto = new ActTicketDto();
        dto.setId(actTicket.getId());
        ActSessionHallSeat actSessionHallSeat = actTicket.getActSessionHallSeat();
        ActSessionHallMapper actSessionHallMapper = new ActSessionHallMapper();
        ActSessionHallSeatDto actSessionHallSeatDto=actSessionHallMapper.toDto(actSessionHallSeat);
        dto.setActSessionHall(actSessionHallSeatDto);
        dto.setFilepath(actTicket.getFilepath());
        dto.setSessionDate(actTicket.getSessionDate());
        dto.setStatus(actTicket.getStatus().toString());
        dto.setUser(UserMapper.toUserDto(actTicket.getUser()));
        dto.setVerificationCode(actTicket.getVerificationCode());
        return dto;
    }


}
