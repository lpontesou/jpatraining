package br.com.ntt.jpa.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
public class EstadoDto {

    @Getter
    @Setter

    private Long id;
    private String nome;


}
