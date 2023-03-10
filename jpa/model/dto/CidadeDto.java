package br.com.ntt.jpa.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
public class CidadeDto {

    @Getter
    @Setter

    private Long id;
    private String nome;

}
