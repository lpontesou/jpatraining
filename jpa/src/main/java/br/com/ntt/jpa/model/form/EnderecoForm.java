package br.com.ntt.jpa.model.form;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EnderecoForm {

    private Long id;
    private String logradouro;
    private String numero;
    private String cep;
    private CidadeForm cidade;
    private EstadoForm estado;

}
