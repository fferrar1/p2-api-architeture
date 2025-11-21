package application.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping
    public CourseDTO insert(@RequestBody CourseInsertDTO newCourse) {
        return courseService.insert(newCourse);
    }

    @GetMapping
    public Iterable<CourseDTO> getAll() {
        return courseService.getAll();
    }

    @GetMapping("/{id}")
    public CourseDTO getOne(@PathVariable long id) {
        return courseService.getOne(id);
    }

    @PutMapping("/{id}")
    public CourseDTO update(@PathVariable long id, @RequestBody CourseInsertDTO data) {
        return courseService.update(id, data);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        courseService.delete(id);
    }
}
