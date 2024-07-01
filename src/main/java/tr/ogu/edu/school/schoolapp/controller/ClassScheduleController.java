package tr.ogu.edu.school.schoolapp.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tr.ogu.edu.school.schoolapp.model.ClassSchedule;
import tr.ogu.edu.school.schoolapp.service.ClassScheduleService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/schedules")
public class ClassScheduleController {


    private final ClassScheduleService classScheduleService;

    @GetMapping
    public List<ClassSchedule> getAllSchedules() {
        return classScheduleService.getAllSchedules();
    }

    @GetMapping("/{id}")
    public ClassSchedule getScheduleById(@PathVariable Long id) {
        return classScheduleService.getScheduleById(id);
    }

    @PostMapping
    public ClassSchedule createSchedule(@RequestBody ClassSchedule classSchedule) {
        return classScheduleService.saveSchedule(classSchedule);
    }




    @DeleteMapping("/{id}")
    public void deleteSchedule(@PathVariable Long id) {
        classScheduleService.deleteSchedule(id);
    }
}