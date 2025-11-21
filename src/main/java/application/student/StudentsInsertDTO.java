package application.student;

import java.time.LocalDate;

public record StudentsInsertDTO(String name, String email, String telephone, LocalDate registrationDate) {
    public StudentsInsertDTO(Students students) {
        this(students.getName(), students.getEmail(), students.getTelephone(), students.getRegistrationDate());
    }
}
