package br.com.ntt.jpa.model.services.populator.impl;

import br.com.ntt.jpa.model.Pessoa;
import br.com.ntt.jpa.model.form.PersonForm;
import br.com.ntt.jpa.model.services.populator.Populator;

public class PersonPopulator implements Populator<PersonForm, Pessoa> {
    @Override
    public void populate(PersonForm source, Pessoa target) {

        target.setNome(source.getNome());
        target.setSobrenome((source.getSobrenome()));
        target.setCpf(source.getCpf());
        target.setEmail(source.getEmail());


    }
}
