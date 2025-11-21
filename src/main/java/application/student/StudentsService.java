package application.student;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class StudentsService {
    @Autowired
    private StudentsRepository studentsRepository;

    public Iterable<StudentsDTO> getAll() {
        return studentsRepository.findAll().stream().map(StudentsDTO::new).toList();
    }

    public StudentsDTO insert(StudentsInsertDTO student) {
        return new StudentsDTO(studentsRepository.save(new Students(student)));
    }

    public StudentsDTO getOne(long id) {
        Optional<Students> result = studentsRepository.findById(id);

        if (result.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Aluno não encontrado"
            );
        }

        return new StudentsDTO(result.get());
    }

    public StudentsDTO update(long id, StudentsInsertDTO student) {
        Optional<Students> result = studentsRepository.findById(id);

        if (result.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Aluno não encontrado"
            );
        }

        Students currentStudent = result.get();

        if (student.name() != null) {
            currentStudent.setName(student.name());
        }
        if (student.email() != null) {
            currentStudent.setEmail(student.email());
        }
        if (student.telephone() != null) {
            currentStudent.setTelephone(student.telephone());
        }
        if (student.registrationDate() != null) {
            currentStudent.setRegistrationDate(student.registrationDate());
        }

        return new StudentsDTO(studentsRepository.save(currentStudent));
    }

    public void delete(long id) {
        Optional<Students> result = studentsRepository.findById(id);

        if (result.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Aluno não encontrado"
            );
        }

        studentsRepository.deleteById(id);
    }
}
