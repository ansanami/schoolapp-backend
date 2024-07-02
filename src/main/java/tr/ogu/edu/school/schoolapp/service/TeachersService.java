package tr.ogu.edu.school.schoolapp.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tr.ogu.edu.school.schoolapp.model.Teachers;
import tr.ogu.edu.school.schoolapp.repository.TeachersRepository;

@Service
public class TeachersService {

    @Autowired
    private TeachersRepository teachersRepository;

    public List<Teachers> getAllTeachers() {
        return teachersRepository.findAll();
    }

    public Teachers getTeacherById(Long id) {
        return teachersRepository.findById(id).orElse(null);
    }

    public Teachers createTeacher(Teachers teacher) {
        return teachersRepository.save(teacher);
    }

    public Teachers updateTeacher(Long id, Teachers teacherDetails) {
        Teachers teacher = teachersRepository.findById(id).orElse(null);

        if (teacher != null) {
            teacher.setName(teacherDetails.getName());
            teacher.setSurname(teacherDetails.getSurname());
            return teachersRepository.save(teacher);
        } else {
            return null;
        }
    }

    public void deleteTeacher(Long id) {
        teachersRepository.deleteById(id);
    }
}
