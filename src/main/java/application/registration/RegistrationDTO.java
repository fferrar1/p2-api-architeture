package application.registration;

import java.time.LocalDate;

import application.course.CourseDTO;
import application.student.StudentsDTO;

public record RegistrationDTO(long id, LocalDate registrationDate, String status, StudentsDTO students, CourseDTO course) {
    public RegistrationDTO(Registration registration) {
        this(registration.getId(),
        registration.getRegistrationDate(),
        registration.getStatus(),
        new StudentsDTO(registration.getStudent()),
        new CourseDTO(registration.getCourse()));
    }
}
