package application.registration;

import java.time.LocalDate;

import application.course.Course;
import application.student.Students;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private LocalDate registrationDate;
    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Students student;
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    public Registration(LocalDate registrationDate, String status, Students student, Course course) {
        this.registrationDate = registrationDate;
        this.status = status;
        this.student = student;
        this.course = course;
    }
}
