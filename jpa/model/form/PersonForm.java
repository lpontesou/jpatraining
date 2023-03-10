package br.com.ntt.jpa.model.form;

import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonForm {

    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String email;
    private EnderecoForm endereco;

}
