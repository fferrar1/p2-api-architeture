package application.course;

import java.time.LocalDateTime;

public record CourseInsertDTO(String name, String description, Integer courseLoad, String status, LocalDateTime creationTime) {
    public CourseInsertDTO(Course data) {
        this(data.getName(), data.getDescription(), data.getCourseLoad(), data.getStatus(), data.getCreationTime());
    }
}
