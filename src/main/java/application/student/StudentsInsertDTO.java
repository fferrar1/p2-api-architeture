package application.student;

public record StudentsInsertDTO(String name, String email, String telephone, String registrationDate) {
    public StudentsInsertDTO(Students students) {
        this(students.getName(), students.getEmail(), students.getTelephone(), students.getRegistrationDate().toString());
    }
}
