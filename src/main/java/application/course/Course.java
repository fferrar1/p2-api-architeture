package application.course;

import java.time.LocalDateTime;

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
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(length = 2000, nullable = false)
    private String description;
    @Column(nullable = false)
    private Integer courseLoad;
    @Column(nullable = false)
    private String status;
    @Column(nullable = false)
    private LocalDateTime creationTime;

    public Course(String name, String description, Integer courseLoad, String status, LocalDateTime creationTime) {
        this.name = name;
        this.description = description;
        this.courseLoad = courseLoad;
        this.status = status;
        this.creationTime = creationTime;
    }
}
