package application.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registrations")
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @PostMapping
    public RegistrationDTO insert(RegistrationInsertDTO data) {
        return registrationService.insert(data);
    }

    @GetMapping
    public Iterable<RegistrationDTO> getAll() {
        return registrationService.getAll();
    }

    @PostMapping("/{id}")
    public RegistrationDTO getOne(long id) {
        return registrationService.getOne(id);
    }

    @DeleteMapping("/{id}")
    public void delete(long id) {
        registrationService.delete(id);
    }
}
