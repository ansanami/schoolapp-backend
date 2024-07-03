package tr.ogu.edu.school.schoolapp.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tr.ogu.edu.school.schoolapp.dto.TeachersDto;
import tr.ogu.edu.school.schoolapp.mapper.TeachersMapper;
import tr.ogu.edu.school.schoolapp.model.Teachers;
import tr.ogu.edu.school.schoolapp.repository.TeachersRepository;

@Service
public class TeachersService {

    @Autowired
    private TeachersRepository teachersRepository;

    @Autowired
    private TeachersMapper teachersMapper;

    public List<Teachers> getAllTeachers() {
        return teachersRepository.findAll();
    }

    public Teachers getTeacherById(Long id) {
        return teachersRepository.findById(id).orElse(null);
    }

    public Teachers createTeacher(Teachers teachers) {
        return teachersRepository.save(teachers);
    }

    public Teachers updateTeacher(Long id, Teachers teachers) {
        Teachers existingTeacher = teachersRepository.findById(id).orElse(null);

        if (existingTeacher != null) {
            existingTeacher.setName(teachers.getName());
            existingTeacher.setSurname(teachers.getSurname());
            return teachersRepository.save(existingTeacher);
        } else {
            return null;
        }
    }

    public void deleteTeacher(Long id) {
        teachersRepository.deleteById(id);
    }
}
