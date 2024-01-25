package ge.nika.projectstructure.models;

import ge.nika.projectstructure.models.enums.Gender;
import ge.nika.projectstructure.models.enums.Subject;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.Objects;

@Entity
@Table(
        name = "Teachers",
        uniqueConstraints = {
                @UniqueConstraint(
                            name = "unique_email",
                            columnNames = "email"
                    )
        }
)
public class TeacherEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", length = 60, nullable = false)
    @NotBlank(message = "name can not be null!")
    private String name;
    @Column(name = "gender", length = 6, nullable = false)
    @NotNull(message = "gender can not be null!")
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(name = "subject", length = 11, nullable = false)
    @Enumerated(EnumType.STRING)
    @NotNull(message = "subject can not be null!")
    private Subject subject;
    @Column(name = "age", length = 2, nullable = false)
    @Min(18)
    @Max(70)
    private int age;
    @Column(name = "email", length = 100, nullable = false)
    @NotBlank(message = "email can't be empty")
    @Email(message = "Invalid email address")
    private String email;
    @Column(name = "mobile", length = 17, nullable = false)
    @Pattern(regexp = "^(\\+995\\s?[5]\\d{2}\\s?\\d{2}\\s?\\d{2}\\s?\\d{2}|\\+9955\\d{8}|\\+995\\s?[5]\\d{2}\\s?\\d{3}\\s?\\d{3}|[5]\\d{8}|[5]\\d{2}\\s?\\d{3}\\s?\\d{3}|[5]\\d{2}\\s?\\d{2}\\s?\\d{2}\\s?\\d{2})$"
            , message = "Invalid mobile number")
    // +995 595 92 91 94 / +995595929194 / +995 595 929 194 / 595 92 91 94 / 595929194 / 595 929 194
    private String mobile;


    public TeacherEntity() {
    }

    public TeacherEntity(Long id, String name, Gender gender, Subject subject, int age, String email, String mobile) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.subject = subject;
        this.age = age;
        this.email = email;
        this.mobile = mobile;
    }

    public TeacherEntity(String name, Gender gender, Subject subject, int age, String email, String mobile) {
        this.name = name;
        this.gender = gender;
        this.subject = subject;
        this.age = age;
        this.email = email;
        this.mobile = mobile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherEntity that = (TeacherEntity) o;
        return age == that.age && Objects.equals(id, that.id) && Objects.equals(name, that.name) && gender == that.gender && subject == that.subject && Objects.equals(email, that.email) && Objects.equals(mobile, that.mobile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, gender, subject, age, email, mobile);
    }

    @Override
    public String toString() {
        return "TeacherEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", subject=" + subject +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}