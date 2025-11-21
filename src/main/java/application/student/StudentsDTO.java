package application.student;

import java.time.LocalDate;

public record StudentsDTO(long id, String name, String email, String telephone, LocalDate registrationDate ) {
    public StudentsDTO(Students students) {
        this(students.getId(), students.getName(), students.getEmail(), students.getTelephone(), students.getRegistrationDate());
    }
}
