package tr.ogu.edu.school.schoolapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.ogu.edu.school.schoolapp.dto.AppointmentDto;
import tr.ogu.edu.school.schoolapp.mapper.AppointmentMapper;
import tr.ogu.edu.school.schoolapp.model.Appointment;
import tr.ogu.edu.school.schoolapp.service.AppointmentService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final AppointmentMapper appointmentMapper;

    @Autowired
    public AppointmentController(AppointmentService appointmentService, AppointmentMapper appointmentMapper) {
        this.appointmentService = appointmentService;
        this.appointmentMapper = appointmentMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDto> getAppointmentById(@PathVariable Long id) {
        Appointment appointment = appointmentService.getAppointmentById(id);
        AppointmentDto appointmentDto = appointmentMapper.toDto(appointment);
        return ResponseEntity.ok(appointmentDto);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<AppointmentDto>> getAppointmentsByUserId(@PathVariable Long userId) {
        List<Appointment> appointments = appointmentService.getAppointmentsByUserId(userId);
        List<AppointmentDto> appointmentDtos = appointments.stream()
                .map(appointmentMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(appointmentDtos);
    }

    @GetMapping
    public ResponseEntity<List<AppointmentDto>> getAllAppointments() {
        List<Appointment> appointments = appointmentService.getAllAppointments();
        List<AppointmentDto> appointmentDtos = appointments.stream()
                .map(appointmentMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(appointmentDtos);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/create")
    public ResponseEntity<AppointmentDto> createAppointment(@RequestBody AppointmentDto appointmentDto) {
        Appointment appointment = appointmentMapper.toEntity(appointmentDto);
        Appointment savedAppointment = appointmentService.createAppointment(appointment);
        AppointmentDto savedAppointmentDto = appointmentMapper.toDto(savedAppointment);
        return ResponseEntity.ok(savedAppointmentDto);
    }
    @GetMapping("/teacher/{teacherId}")
    public ResponseEntity<List<AppointmentDto>> getAppointmentsByTeacherId(@PathVariable Long teacherId) {
        List<Appointment> appointments = appointmentService.getAppointmentsByTeacherId(teacherId);
        List<AppointmentDto> appointmentDtos = appointments.stream()
                .map(appointmentMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(appointmentDtos);
    }
}
