package br.com.ntt.jpa.model.dto;

import br.com.ntt.jpa.model.Endereco;
import br.com.ntt.jpa.model.Pessoa;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonDto {

        private Long id;
        private String nome;
        private String sobrenome;
        private String cpf;
        private String email;
        private Endereco endereco;

        public PersonDto(Pessoa pessoa) {
                this.id = pessoa.getId();
                this.nome = pessoa.getNome();
                this.sobrenome = pessoa.getSobrenome();
                this.email = pessoa.getEmail();
                this.cpf = pessoa.getCpf();
                this.endereco = pessoa.getEndereco();
        }



}


