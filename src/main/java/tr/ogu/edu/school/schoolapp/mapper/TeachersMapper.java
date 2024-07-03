package tr.ogu.edu.school.schoolapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import tr.ogu.edu.school.schoolapp.dto.TeachersDto;
import tr.ogu.edu.school.schoolapp.model.Teachers;

@Mapper(componentModel = "spring")
public interface TeachersMapper {

    TeachersMapper INSTANCE = Mappers.getMapper(TeachersMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "surname", target = "surname")
    TeachersDto toDto(Teachers teachers);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "surname", target = "surname")
    Teachers toEntity(TeachersDto teachersDto);
}
