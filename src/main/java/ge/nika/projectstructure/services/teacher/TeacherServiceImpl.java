package ge.nika.projectstructure.services.teacher;

import ge.nika.projectstructure.exception.EntityNotFoundException;
import ge.nika.projectstructure.models.TeacherEntity;
import ge.nika.projectstructure.models.enums.Subject;
import ge.nika.projectstructure.repositories.TeacherRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<TeacherEntity> retrieveAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public TeacherEntity retrieveTeacherById(Long id) throws EntityNotFoundException {
        Optional<TeacherEntity> teacher = teacherRepository.findById(id);
        if (teacher.isPresent()) {
            return teacher.get();
        }
        throw new EntityNotFoundException("Could not find Teacher with id: " + id);
    }
    @Override
    @Transactional(readOnly = true)
    public List<TeacherEntity> retrieveTeacherBySubject(Subject subject) throws EntityNotFoundException {
        List<TeacherEntity> teachers = teacherRepository.findTeachersBySubject(subject);
        if (teachers.isEmpty()) {
            throw new EntityNotFoundException("Could not find Teacher for subject: " + subject);
        }
        return teachers;
    }
    
    @Override
    @Transactional
    public void addNewTeacher(TeacherEntity teacher) {
        Optional<TeacherEntity> teacherEntity = teacherRepository.findTeacherEntityByEmail(teacher.getEmail());
        if (teacherEntity.isPresent()) {
            throw new IllegalStateException("Other Teacher has already taken that email!");
        }
        teacherRepository.save(teacher);
    }

    @Override
    @Transactional
    public void updateTeacher(Long id, TeacherEntity teacher) throws EntityNotFoundException {
        Optional<TeacherEntity> teacherEntity = teacherRepository.findById(id);
        if (teacherEntity.isPresent()) {
            teacher.setId(id);
            teacherRepository.save(teacher);
        } else {
            throw new EntityNotFoundException("Teacher with id " + id + " doesn't exists");
        }
    }

    @Override
    @Transactional
    public void deleteTeacher(Long id) throws EntityNotFoundException {
        if (!teacherRepository.existsById(id)) {
            throw new EntityNotFoundException("Teacher with id " + id + " doesn't exists");
        }
        teacherRepository.deleteById(id);
    }

}