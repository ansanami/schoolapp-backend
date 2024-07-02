package tr.ogu.edu.school.schoolapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import tr.ogu.edu.school.schoolapp.dto.AppointmentDto;
import tr.ogu.edu.school.schoolapp.model.Appointment;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {
    AppointmentMapper INSTANCE = Mappers.getMapper(AppointmentMapper.class);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "teacher.id", target = "teacherId")
    AppointmentDto toDto(Appointment appointment);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "teacherId", target = "teacher.id")
    Appointment toEntity(AppointmentDto appointmentDto);
}
