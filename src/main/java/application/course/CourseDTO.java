package application.course;

import java.time.LocalDateTime;

public record CourseDTO(long id, String name, String description, Integer courseLoad, String status, LocalDateTime creationTime) {
    public CourseDTO(Course data) {
        this(data.getId(), data.getName(), data.getDescription(), data.getCourseLoad(), data.getStatus(), data.getCreationTime());
    }
}
