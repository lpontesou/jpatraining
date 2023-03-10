package br.com.ntt.jpa.model.form;

import br.com.ntt.jpa.model.Cidade;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class EstadoForm {

    private Long id;
    private String nome;
    private List<CidadeForm> cidades;

}
