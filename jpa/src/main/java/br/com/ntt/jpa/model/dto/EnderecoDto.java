package br.com.ntt.jpa.model.dto;

import br.com.ntt.jpa.model.Cidade;
import br.com.ntt.jpa.model.Estado;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
public class EnderecoDto {

    @Getter
    @Setter

    private Long id;
    private String logradouro;
    private String numero;
    private String cep;

    @OneToOne
    private Estado estado;
    @OneToOne
    private Cidade cidade;


}
