package tr.ogu.edu.school.schoolapp.mapper;

import tr.ogu.edu.school.schoolapp.dto.ActSeatDto;
import tr.ogu.edu.school.schoolapp.model.ActSeat;

public class ActSeatMapper extends DtoEntityMapper<ActSeat, ActSeatDto> {

	public static final ActSeatMapper INSTANCE = new ActSeatMapper();

	@Override
	public ActSeatDto toDto(ActSeat entity) {
		ActSeatDto dto = new ActSeatDto();
		dto.setId(entity.getId());
		dto.setLine(entity.getLine());
		dto.setNo(entity.getNo());
		dto.setCategoryId(entity.getActCategory().getId());
		dto.setHallId(entity.getActHall().getId());
		return dto;
	}

	@Override
	public ActSeat toEntity(ActSeatDto dto) {
		ActSeat entity = new ActSeat();
		entity.setId(dto.getId());
		entity.setLine(dto.getLine());
		entity.setNo(dto.getNo());
		// Optionally, you can set ActCategory if needed
		// entity.setActCategory(ActCategoryMapper.INSTANCE.toEntity(dto.getActCategory()));
		return entity;
	}
}
