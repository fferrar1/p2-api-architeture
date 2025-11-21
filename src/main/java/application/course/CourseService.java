package application.course;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepo;

    public Iterable<CourseDTO> getAll() {
        return courseRepo.findAll().stream().map(CourseDTO::new).toList();
    }

    public CourseDTO insert(CourseInsertDTO data) {
        return new CourseDTO(courseRepo.save(new Course(data)));
    }

    public CourseDTO getOne(@PathVariable long id) {
        Optional<Course> result = courseRepo.findById(id);

        if (result.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Curso não encontrado"
            );
        }

        return new CourseDTO(result.get());
    }

    public CourseDTO update(long id, CourseInsertDTO data) {
        Optional<Course> result = courseRepo.findById(id);

        if (result.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Curso não encontrado"
            );
        }

        Course currentCourse = result.get();

        if (data.name() != null) {
            currentCourse.setName(data.name());
        }
        if (data.description() != null) {
            currentCourse.setDescription(data.description());
        }
        if (data.courseLoad() != null) {
            currentCourse.setCourseLoad(data.courseLoad());
        }
        if (data.status() != null) {
            currentCourse.setStatus(data.status());
        }
        if (data.creationTime() != null) {
            currentCourse.setCreationTime(data.creationTime());
        }

        return new CourseDTO(courseRepo.save(currentCourse));
    }

    public void delete(long id) {
        if (!courseRepo.existsById(id)){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Curso não encontrado"
            );
        }

        courseRepo.deleteById(id);
    }
}
