package tr.ogu.edu.school.schoolapp.mapper;

import tr.ogu.edu.school.schoolapp.dto.ActHallDto;
import tr.ogu.edu.school.schoolapp.dto.ActSeatDto;
import tr.ogu.edu.school.schoolapp.model.ActHall;

public class ActHallMapper extends DtoEntityMapper<ActHall, ActHallDto> {

    public static final ActHallMapper INSTANCE = new ActHallMapper();

    @Override
    public ActHallDto toDto(ActHall entity) {
        ActHallDto dto = new ActHallDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    @Override
    public ActHall toEntity(ActHallDto dto) {
        return null;
    }

}
