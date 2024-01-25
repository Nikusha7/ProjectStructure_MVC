package ge.nika.projectstructure.configs;

import ge.nika.projectstructure.models.TeacherEntity;
import ge.nika.projectstructure.models.enums.Gender;
import ge.nika.projectstructure.models.enums.Subject;
import ge.nika.projectstructure.repositories.TeacherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

// This configuration class initializes and stores sample teacher entities in the database.

@Configuration
// This class is marked as a configuration class.
// In Spring, @Configuration indicates that this class will define beans and configuration settings.
public class TeacherConfig {
    // This method is marked with @Bean, signaling that it produces a bean managed by the Spring IoC container.
    // CommandLineRunner is a functional interface used for executing code during the Spring Boot application startup.
    // The method takes a TeacherRepository as a parameter, which Spring automatically injects into the method.
    @Bean
    CommandLineRunner commandLineRunner(TeacherRepository teacherRepository) {
        return args -> {
            TeacherEntity mariam = new TeacherEntity(
                    "mariam",
                    Gender.FEMALE,
                    Subject.CHEMISTRY,
                    25,
                    "mariam@gmail.com",
                    "595 93 92 91"
            );
            TeacherEntity paula = new TeacherEntity(
                    "paula",
                    Gender.FEMALE,
                    Subject.BIOLOGY,
                    29,
                    "paula@gmail.com",
                    "595939291"
            );
            TeacherEntity nick = new TeacherEntity(
                    "nick",
                    Gender.MALE,
                    Subject.MATHEMATICS,
                    19,
                    "nick@gmail.com",
                    "595 939 291"
            );
            TeacherEntity bob = new TeacherEntity(
                    "bob",
                    Gender.MALE,
                    Subject.PROGRAMMING,
                    21,
                    "bob@gmail.com",
                    "+995 595 93 92 91"
            );

            TeacherEntity chris = new TeacherEntity(
                    "Chris",
                    Gender.MALE,
                    Subject.PHYSICS,
                    29,
                    "chris@gmail.com",
                    "+995595939291"
            );

            TeacherEntity adele = new TeacherEntity(
                    "Adele",
                    Gender.FEMALE,
                    Subject.HISTORY,
                    50,
                    "adele@gmail.com",
                    "+995 595 939 291"
            );

            List<TeacherEntity> teachers = List.of(mariam, paula, nick, bob, chris, adele);
            teacherRepository.saveAll(teachers);
        };
    }

}