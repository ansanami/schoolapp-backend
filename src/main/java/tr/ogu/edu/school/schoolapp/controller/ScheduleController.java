package tr.ogu.edu.school.schoolapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.SchedulingException;
import org.springframework.web.bind.annotation.*;
import tr.ogu.edu.school.schoolapp.model.Schedule;
import tr.ogu.edu.school.schoolapp.service.ScheduleService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @GetMapping
    public List<Schedule> getAllSchedules() {
        return scheduleService.getAllSchedules();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Schedule> getScheduleById(@PathVariable Long id) {
        Optional<Schedule> schedule = scheduleService.getScheduleById(id);
        return schedule.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Schedule createSchedule(@RequestBody Schedule schedule) {
        return scheduleService.saveSchedule(schedule);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Schedule> updateSchedule(@PathVariable Long id, @RequestBody Schedule scheduleDetails) {
        Optional<Schedule> schedule = scheduleService.getScheduleById(id);
        if (schedule.isPresent()) {
            Schedule existingSchedule = schedule.get();
            existingSchedule.setDayOfWeek(scheduleDetails.getDayOfWeek());
            existingSchedule.setPeriod1(scheduleDetails.getPeriod1());
            existingSchedule.setPeriod2(scheduleDetails.getPeriod2());
            existingSchedule.setPeriod3(scheduleDetails.getPeriod3());
            existingSchedule.setPeriod4(scheduleDetails.getPeriod4());
            existingSchedule.setPeriod5(scheduleDetails.getPeriod5());
            existingSchedule.setPeriod6(scheduleDetails.getPeriod6());
            Schedule updatedSchedule = scheduleService.saveSchedule(existingSchedule);
            return ResponseEntity.ok(updatedSchedule);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteSchedule(id);
        return ResponseEntity.noContent().build();
    }
}
