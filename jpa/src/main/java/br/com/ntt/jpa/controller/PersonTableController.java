package br.com.ntt.jpa.controller;

import br.com.ntt.jpa.model.Pessoa;
import br.com.ntt.jpa.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/people")
public class PersonTableController {

    @Autowired
    PessoaRepository pessoaRepository;

    // Get all people
    @GetMapping
    public ResponseEntity<List<Pessoa>> getAllPeople() {
        List<Pessoa> pessoas = pessoaRepository.findAll();
        return new ResponseEntity<>(pessoas, HttpStatus.OK);
    }

    // Get person by ID
    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> getPersonById(@PathVariable("id") Long id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        if (pessoa.isPresent()) {
            return new ResponseEntity<>(pessoa.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
