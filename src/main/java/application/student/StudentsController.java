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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/students")
public class StudentsController {
    @Autowired
    private StudentsService studentsService;

    @PostMapping
    @Operation(summary = "Cria um novo estudante",
            description = "Cria um novo estudante com as informações fornecidas no corpo da requisição.")
    @ApiResponse(responseCode = "200", description = "Estudante criado com sucesso")
    public StudentsDTO insert(@RequestBody StudentsInsertDTO student) {
        return studentsService.insert(student);
    }

    @GetMapping
    @Operation(summary = "Lista todos os estudantes",
            description = "Retorna uma lista de todos os estudantes cadastrados no sistema.")
    @ApiResponse(responseCode = "200", description = "Lista de estudantes retornada com sucesso")
    public Iterable<StudentsDTO> getAll() {
        return studentsService.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtém um estudante por ID",
            description = "Retorna os detalhes de um estudante específico com base no ID fornecido.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Estudante encontrado e retornado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Estudante não encontrado")
    })
    public StudentsDTO getOne(@Parameter(description = "ID do estudante a ser consultado.") @PathVariable long id) {
        return studentsService.getOne(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um estudante existente",
            description = "Atualiza as informações de um estudante específico com base no ID fornecido e nos dados fornecidos no corpo da requisição.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Estudante atualizado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Estudante não encontrado")
    })
    public StudentsDTO update(@Parameter(description = "ID do estudante a ser atualizado.") @PathVariable long id, @RequestBody StudentsInsertDTO student) {
        return studentsService.update(id, student);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove um estudante",
            description = "Remove um estudante específico com base no ID fornecido.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Estudante removido com sucesso"),
        @ApiResponse(responseCode = "404", description = "Estudante não encontrado")
    })
    public void delete(@Parameter(description = "ID do estudante a ser removido.") @PathVariable long id) {
        studentsService.delete(id);
    }
}
