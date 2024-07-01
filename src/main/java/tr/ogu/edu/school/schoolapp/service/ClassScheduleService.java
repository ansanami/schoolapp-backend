package tr.ogu.edu.school.schoolapp.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.ogu.edu.school.schoolapp.model.ClassSchedule;
import tr.ogu.edu.school.schoolapp.repository.ClassScheduleRepository;

import java.util.List;

@Service
public class ClassScheduleService {


    private final ClassScheduleRepository classScheduleRepository;
    @Autowired
    public ClassScheduleService(ClassScheduleRepository classScheduleRepository) {
        this.classScheduleRepository = classScheduleRepository;
    }

    public List<ClassSchedule> getAllSchedules() {
        return classScheduleRepository.findAll();
    }

    public ClassSchedule getScheduleById(Long id) {
        return classScheduleRepository.findById(id).orElse(null);
    }

    public ClassSchedule saveSchedule(ClassSchedule classSchedule) {
        return classScheduleRepository.save(classSchedule);
    }

    public void deleteSchedule(Long id) {
        classScheduleRepository.deleteById(id);
    }
}