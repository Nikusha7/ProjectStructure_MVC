package ge.nika.projectstructure.controllers;

import ge.nika.projectstructure.exception.EntityNotFoundException;
import ge.nika.projectstructure.models.TeacherEntity;
import ge.nika.projectstructure.models.enums.Subject;
import ge.nika.projectstructure.services.teacher.TeacherServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("teacher")
public class TeacherController {

    private TeacherServiceImpl teacherService;

    public TeacherController(TeacherServiceImpl teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<TeacherEntity> getAllTeachers() {
        return teacherService.retrieveAllTeachers();
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("/id/{id}")
    public TeacherEntity getTeacherById(@PathVariable Long id) throws EntityNotFoundException {
        return teacherService.retrieveTeacherById(id);
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("/subject/{subject}")
    public List<TeacherEntity> getTeachersBySubject(@PathVariable Subject subject) throws EntityNotFoundException {
        return teacherService.retrieveTeacherBySubject(subject);
    }


    @PostMapping("/add")
    public ResponseEntity<String> addNewTeacher(@RequestBody @Valid TeacherEntity teacher) {
        teacherService.addNewTeacher(teacher);

        // If the teacher is added successfully, return a custom response
        String responseBody = "Teacher added successfully";
        return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updateTeacher(@PathVariable Long id, @RequestBody @Valid TeacherEntity teacher) throws EntityNotFoundException {
        teacherService.updateTeacher(id, teacher);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable("id") Long id) throws EntityNotFoundException{
        teacherService.deleteTeacher(id);
    }


}