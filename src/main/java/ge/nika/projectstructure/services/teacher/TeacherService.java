package ge.nika.projectstructure.services.teacher;

import ge.nika.projectstructure.exception.EntityNotFoundException;
import ge.nika.projectstructure.models.TeacherEntity;
import ge.nika.projectstructure.models.enums.Subject;

import java.util.List;

public interface TeacherService {
    List<TeacherEntity> retrieveAllTeachers();

    TeacherEntity retrieveTeacherById(Long id) throws EntityNotFoundException;

    List<TeacherEntity> retrieveTeacherBySubject(Subject subject) throws EntityNotFoundException;

    void addNewTeacher(TeacherEntity teacher);

    void updateTeacher(Long id, TeacherEntity teacher) throws EntityNotFoundException;

    void deleteTeacher(Long id) throws EntityNotFoundException;
}