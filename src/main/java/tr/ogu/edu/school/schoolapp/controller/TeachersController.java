package tr.ogu.edu.school.schoolapp.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tr.ogu.edu.school.schoolapp.dto.TeachersDto;
import tr.ogu.edu.school.schoolapp.mapper.TeachersMapper;
import tr.ogu.edu.school.schoolapp.model.Teachers;
import tr.ogu.edu.school.schoolapp.service.TeachersService;

@RestController
@RequestMapping("/teachers")
public class TeachersController {

    @Autowired
    private TeachersService teachersService;

    @Autowired
    private TeachersMapper teachersMapper;

    @GetMapping
    public ResponseEntity<List<TeachersDto>> getAllTeachers() {
        List<Teachers> teachers = teachersService.getAllTeachers();
        List<TeachersDto> teachersDtoList = teachers.stream()
                .map(teachersMapper::toDto)  // Map each Teachers object to TeachersDto
                .collect(Collectors.toList());
        return ResponseEntity.ok(teachersDtoList);
    }


    @GetMapping("/{id}")
    public ResponseEntity<TeachersDto> getTeacherById(@PathVariable Long id) {
        Teachers teacher = teachersService.getTeacherById(id);
        return teacher != null ? ResponseEntity.ok(teachersMapper.toDto(teacher)) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<TeachersDto> createTeacher(@RequestBody TeachersDto teacherDto) {
        Teachers teacher = teachersMapper.toEntity(teacherDto);
        Teachers createdTeacher = teachersService.createTeacher(teacher);
        return ResponseEntity.ok(teachersMapper.toDto(createdTeacher));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeachersDto> updateTeacher(@PathVariable Long id, @RequestBody TeachersDto teacherDto) {
        Teachers teacher = teachersMapper.toEntity(teacherDto);
        Teachers updatedTeacher = teachersService.updateTeacher(id, teacher);
        return updatedTeacher != null ? ResponseEntity.ok(teachersMapper.toDto(updatedTeacher)) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable Long id) {
        teachersService.deleteTeacher(id);
        return ResponseEntity.noContent().build();
    }
}
