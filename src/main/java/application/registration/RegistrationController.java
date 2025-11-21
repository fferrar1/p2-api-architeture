package application.registration;

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
@RequestMapping("/registrations")
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @PostMapping
    public RegistrationDTO insert(@RequestBody RegistrationInsertDTO data) {
        return registrationService.insert(data);
    }

    @GetMapping
    public Iterable<RegistrationDTO> getAll() {
        return registrationService.getAll();
    }

    @PutMapping("/{id}")
    public RegistrationDTO update(@PathVariable long id, @RequestBody RegistrationInsertDTO data) {
        return registrationService.update(id, data);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        registrationService.delete(id);
    }
}
