package tr.ogu.edu.school.schoolapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tr.ogu.edu.school.schoolapp.model.Teachers;
import tr.ogu.edu.school.schoolapp.service.TeachersService;

@RestController
@RequestMapping("/teachers")
public class TeachersController {

    @Autowired
    private TeachersService teachersService;

    @GetMapping
    public ResponseEntity<List<Teachers>> getAllTeachers() {
        List<Teachers> teachers = teachersService.getAllTeachers();
        return ResponseEntity.ok(teachers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teachers> getTeacherById(@PathVariable Long id) {
        Teachers teacher = teachersService.getTeacherById(id);
        return teacher != null ? ResponseEntity.ok(teacher) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Teachers> createTeacher(@RequestBody Teachers teacher) {
        Teachers createdTeacher = teachersService.createTeacher(teacher);
        return ResponseEntity.ok(createdTeacher);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Teachers> updateTeacher(@PathVariable Long id, @RequestBody Teachers teacherDetails) {
        Teachers updatedTeacher = teachersService.updateTeacher(id, teacherDetails);
        return updatedTeacher != null ? ResponseEntity.ok(updatedTeacher) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable Long id) {
        teachersService.deleteTeacher(id);
        return ResponseEntity.noContent().build();
    }
}
