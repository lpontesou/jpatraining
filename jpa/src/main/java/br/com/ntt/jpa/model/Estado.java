package br.com.ntt.jpa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "tb_estados")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @OneToMany
    private List<Cidade> cidades = new ArrayList<>();

    public static Estado criarNovoEstado(String nome, List<Cidade> cidades) {
        Estado estado = new Estado();
        estado.setNome(nome);
        return estado;
    }



}
