package tr.ogu.edu.school.schoolapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import tr.ogu.edu.school.schoolapp.dto.AppointmentDto;
import tr.ogu.edu.school.schoolapp.model.Appointment;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {
    AppointmentMapper INSTANCE = Mappers.getMapper(AppointmentMapper.class);

    AppointmentDto toDto(Appointment appointment);

    Appointment toEntity(AppointmentDto appointmentDto);
}
