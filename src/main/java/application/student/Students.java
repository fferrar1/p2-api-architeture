package application.student;

import java.time.LocalDate;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "telephone", nullable = false)
    private String telephone;
    @Column(name = "registrationDate", nullable = false)
    private LocalDate registrationDate;

    public Students(String name, String email, String telephone, LocalDate registrationDate) {
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.registrationDate = registrationDate;
    }

    public Students(StudentsDTO student) {
        this.id = student.id();
        this.name = student.name();
        this.email = student.email();
        this.telephone = student.telephone();
        this.registrationDate = student.registrationDate();
    }

    public Students(StudentsInsertDTO student) {
        this.name = student.name();
        this.email = student.email();
        this.telephone = student.telephone();
        this.registrationDate = student.registrationDate();
    }
}
