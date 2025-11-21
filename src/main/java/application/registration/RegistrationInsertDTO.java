package application.registration;

import java.time.LocalDate;

public record RegistrationInsertDTO(LocalDate registrationDate, String status, long studentId, long courseId) {
    public RegistrationInsertDTO(Registration registration) {
        this(registration.getRegistrationDate(),
        registration.getStatus(),
        registration.getStudent().getId(),
        registration.getCourse().getId());
    }
}
