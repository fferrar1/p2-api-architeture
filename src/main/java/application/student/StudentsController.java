package application.student;

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
@RequestMapping("/students")
public class StudentsController {
    @Autowired
    private StudentsService studentsService;

    @PostMapping
    public StudentsDTO insert(@RequestBody StudentsInsertDTO student) {
        return studentsService.insert(student);
    }

    @GetMapping
    public Iterable<StudentsDTO> getAll() {
        return studentsService.getAll();
    }

    @GetMapping("/{id}")
    public StudentsDTO getOne(@PathVariable long id) {
        return studentsService.getOne(id);
    }

    @PutMapping("/{id}")
    public StudentsDTO update(@PathVariable long id, @RequestBody StudentsInsertDTO student) {
        return studentsService.update(id, student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        studentsService.delete(id);
    }
}
