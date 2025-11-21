package application.student;

public record StudentsDTO(long id, String name, String email, String telephone, String registrationDate ) {
    public StudentsDTO(Students students) {
        this(students.getId(), students.getName(), students.getEmail(), students.getTelephone(), students.getRegistrationDate().toString());
    }
}
