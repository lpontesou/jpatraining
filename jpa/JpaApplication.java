package br.com.ntt.jpa;

import br.com.ntt.jpa.exception.PessoaNaoEncontradaException;
import br.com.ntt.jpa.model.Cidade;
import br.com.ntt.jpa.model.Endereco;
import br.com.ntt.jpa.model.Estado;
import br.com.ntt.jpa.model.Pessoa;
import br.com.ntt.jpa.repository.CidadeRepository;
import br.com.ntt.jpa.repository.EnderecoRepository;
import br.com.ntt.jpa.repository.EstadoRepository;
import br.com.ntt.jpa.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PessoaRepository pessoaRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args); }

	@Override
	public void run(String... args) throws Exception {
	/*	Cidade campinas = Cidade.criarNovaCidade("campinas");
		cidadeRepository.save(campinas);

		Estado sp = Estado.criarNovoEstado ( "sp", Arrays.asList(campinas));
		estadoRepository.save(sp);

		Endereco endereco = Endereco.criarNovoEndereco( "rua 1",  "um", "00000-000", sp, campinas);
		enderecoRepository.save(endereco);

		Pessoa maria = Pessoa.criarNovaPessoa ("maria","luz", "00000000000","maria@email.com", endereco);
		pessoaRepository.save(maria);

		Pessoa jorge = Pessoa.criarNovaPessoa("jorge", "amado", "03111111111", "jorge@jorge.com", endereco);
		pessoaRepository.save(jorge);*/

		/////////////

		try {
		pessoaRepository.findById(1L).orElseThrow(() -> new PessoaNaoEncontradaException("Não existe um cadastro com este id"));
		} catch (PessoaNaoEncontradaException ex) {
			System.out.println(ex.getMessage());
		}

	}}

