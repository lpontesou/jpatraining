package br.com.ntt.jpa.controller;

import br.com.ntt.jpa.model.Pessoa;
import br.com.ntt.jpa.model.dto.PersonDto;
import br.com.ntt.jpa.model.services.PersonService;
import br.com.ntt.jpa.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonTableController {

    private final PersonService personService;

    public PersonTableController(PersonService personService) {
        this.personService = personService;
    }
    @Autowired
    PessoaRepository pessoaRepository;


    // Get all people
    @GetMapping
    public ResponseEntity<List<PersonDto>> getAllPeople() {
        List<Pessoa> pessoas = pessoaRepository.findAll();
        List<PersonDto> personDtos = new ArrayList<>();

        for (Pessoa pessoa : pessoas) {
            PersonDto personDto = new PersonDto();
            personDto.setId(pessoa.getId());
            personDto.setNome(pessoa.getNome());
            personDto.setSobrenome(pessoa.getSobrenome());
            personDto.setEmail(pessoa.getEmail());
            personDto.setCpf(pessoa.getCpf());
            personDto.setEndereco(pessoa.getEndereco());
            personDtos.add(personDto);
        }
        return new ResponseEntity<>(personDtos, HttpStatus.OK);
    }

    // Get person by ID
    @GetMapping("/{id}")
    public ResponseEntity<PersonDto> getPersonById(@PathVariable("id") Long id) {
        PersonDto personDto = personService.getPersonById(id);

        if (personDto != null) {
            return ResponseEntity.ok(personDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
