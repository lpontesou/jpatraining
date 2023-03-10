package br.com.ntt.jpa.controller;

import br.com.ntt.jpa.model.form.PersonForm;
import br.com.ntt.jpa.model.services.PersonService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonFormController {
    private final PersonService personService;

    public PersonFormController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/newpersonform")
    public String criarNovaPessoaSalvarNoBanco(@RequestBody PersonForm personForm) {
        personService.salvarPessoa(personForm);
        return "redirect:/my-form";
    }
}

