package ge.nika.projectstructure.repositories;

import ge.nika.projectstructure.models.TeacherEntity;
import ge.nika.projectstructure.models.enums.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for managing Teacher entities. Extends JpaRepository
 * to inherit common CRUD operations and provides a custom query method for finding a student by email or by some other properties.
 *
 * The Repository annotation indicates that this interface is a Spring bean and
 * should be automatically discovered by Spring during component scanning.
 */
@Repository
public interface TeacherRepository
        extends JpaRepository<TeacherEntity, Long> {
    /**
     * Custom query method to find a TeacherEntity by their email address.
     *
     * @param email The email address of the teacher to be found.
     * @return An Optional containing the found teacher or an empty Optional if not found.
     *
     * Method Naming Convention:
     * - The method name starts with "find" indicating a retrieval operation.
     * - The entity type "TeacherEntity" specifies the type of the entity being queried.
     * - "ByEmail" indicates the property used for filtering the search.
     */
    Optional<TeacherEntity> findTeacherEntityByEmail(String email);

    List<TeacherEntity> findTeachersBySubject(Subject subject);

}