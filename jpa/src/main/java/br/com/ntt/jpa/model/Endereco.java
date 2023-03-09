package br.com.ntt.jpa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "tb_enderecos")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String logradouro;
    private String numero;
    private String cep;

    @OneToOne
    private Estado estado;
    @OneToOne
    private Cidade cidade;

    public static Endereco criarNovoEndereco(String logradouro, String numero, String cep, Estado estado, Cidade cidade) {
        Endereco endereco = new Endereco();
        endereco.setLogradouro(logradouro);
        endereco.setNumero(numero);
        endereco.setCep(cep);
        endereco.setEstado(estado);
        endereco.setCidade(cidade);
        return endereco;
    }

}
