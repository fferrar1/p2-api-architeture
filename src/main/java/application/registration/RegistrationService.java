package application.registration;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import application.course.Course;
import application.course.CourseRepository;
import application.student.Students;
import application.student.StudentsRepository;

@Service
public class RegistrationService {
    @Autowired
    private RegistrationRepository registrationRepo;
    @Autowired
    private StudentsRepository studentsRepo;
    @Autowired
    private CourseRepository courseRepo;

    public Iterable<RegistrationDTO> getAll() {
        return registrationRepo.findAll().stream().map(RegistrationDTO::new).toList();
    }

    public RegistrationDTO insert(RegistrationInsertDTO data) {
        Optional<Students> stuResult = studentsRepo.findById(data.studentId());
        Optional<Course> couResult = courseRepo.findById(data.courseId());

        String errorMessage = "Data not found for: ";
        boolean hasError = false;

        if (stuResult.isEmpty()) {
            errorMessage += "studentId=" + data.studentId() + " ";
            hasError = true;
        }
        if (couResult.isEmpty()) {
            errorMessage += "courseId=" + data.courseId() + " ";
            hasError = true;
        }
        if (hasError) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, errorMessage
            );
        }

        Registration newRegistration = new Registration();
        newRegistration.setRegistrationDate(data.registrationDate());
        newRegistration.setStatus(data.status());
        newRegistration.setStudent(stuResult.get());
        newRegistration.setCourse(couResult.get());

        return new RegistrationDTO(registrationRepo.save(newRegistration));
    }

    public RegistrationDTO getOne(long id) {
        return registrationRepo.findById(id).map(RegistrationDTO::new).orElseThrow(() -> new ResponseStatusException(
            HttpStatus.NOT_FOUND, "Registration not found for id=" + id
        ));
    }

    public RegistrationDTO update(long id, RegistrationInsertDTO data) {
        Optional<Registration> regResult = registrationRepo.findById(id);
        if (regResult.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Registration not found for id=" + id
            );
        }
        Optional<Students> stuResult = studentsRepo.findById(data.studentId());
        Optional<Course> couResult = courseRepo.findById(data.courseId());

        String errorMessage = "Data not found for: ";
        boolean hasError = false;

        if (stuResult.isEmpty()) {
            errorMessage += "studentId=" + data.studentId() + " ";
            hasError = true;
        }
        if (couResult.isEmpty()) {
            errorMessage += "courseId=" + data.courseId() + " ";
            hasError = true;
        }
        if (hasError) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, errorMessage
            );
        }

        Registration registration = regResult.get();
        if (data.registrationDate() != null) {
            registration.setRegistrationDate(data.registrationDate());
        }
        if (data.status() != null) {
            registration.setStatus(data.status());
        }
        registration.setStudent(stuResult.get());
        registration.setCourse(couResult.get());

        return new RegistrationDTO(registrationRepo.save(registration));
    }

    public void delete(long id) {
        if (!registrationRepo.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Registration not found for id=" + id
            );
        }
        registrationRepo.deleteById(id);
    }
}
