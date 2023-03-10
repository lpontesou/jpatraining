package br.com.ntt.jpa.model.services;

import br.com.ntt.jpa.model.Cidade;
import br.com.ntt.jpa.model.Endereco;
import br.com.ntt.jpa.model.Estado;
import br.com.ntt.jpa.model.Pessoa;

import br.com.ntt.jpa.model.dto.PersonDto;
import br.com.ntt.jpa.model.form.PersonForm;
import br.com.ntt.jpa.repository.CidadeRepository;
import br.com.ntt.jpa.repository.EnderecoRepository;
import br.com.ntt.jpa.repository.EstadoRepository;
import br.com.ntt.jpa.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {
    private final PessoaRepository pessoaRepository;
    private final EstadoRepository estadoRepository;
    private final CidadeRepository cidadeRepository;
    private final EnderecoRepository enderecoRepository;

    public PersonService(PessoaRepository pessoaRepository, EstadoRepository estadoRepository, CidadeRepository cidadeRepository, EnderecoRepository enderecoRepository) {
        this.pessoaRepository = pessoaRepository;
        this.estadoRepository = estadoRepository;
        this.cidadeRepository = cidadeRepository;
        this.enderecoRepository = enderecoRepository;

    }

    public void salvarPessoa(PersonForm personForm) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(personForm.getNome());
        pessoa.setSobrenome(personForm.getSobrenome());
        pessoa.setCpf(personForm.getCpf());
        pessoa.setEmail(personForm.getEmail());

            Endereco endereco = new Endereco();
            endereco.setLogradouro(personForm.getEndereco().getLogradouro());
            endereco.setNumero(personForm.getEndereco().getNumero());
            endereco.setCep(personForm.getEndereco().getCep());

                Estado estado = new Estado();
                estado.setNome(personForm.getEndereco().getEstado().getNome());

                Cidade cidade = new Cidade();
                cidade.setNome(personForm.getEndereco().getCidade().getNome());

            endereco.setCidade(cidade);
            cidadeRepository.save(cidade);
            endereco.setEstado(estado);
            estadoRepository.save(estado);
            enderecoRepository.save(endereco);

        pessoa.setEndereco(endereco);

        pessoaRepository.save(pessoa);
    }

    public PersonDto getPersonById(Long id) {
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(id);

        if (pessoaOptional.isPresent()) {
            Pessoa pessoa = pessoaOptional.get();
            return new PersonDto(pessoa);
        }

        return null;
    }
}
