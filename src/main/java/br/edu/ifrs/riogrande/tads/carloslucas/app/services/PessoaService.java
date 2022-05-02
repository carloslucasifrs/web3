package br.edu.ifrs.riogrande.tads.carloslucas.app.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrs.riogrande.tads.carloslucas.app.exceptions.NotFoundException;
import br.edu.ifrs.riogrande.tads.carloslucas.app.model.Pessoa;
import br.edu.ifrs.riogrande.tads.carloslucas.app.repository.PessoaRepository;
import br.edu.ifrs.riogrande.tads.carloslucas.app.services.dto.PessoaRequest;

@Service
public class PessoaService { // Use Case (independente da comunição)
	// Feign, RestTemplate
	// DAO: Data Access Object, DAL: Data Access Layer
	// Inversão da Dependência (Clean Code)
	private final PessoaRepository repository; // inspirado na ideia do Eric Evans (DDD)

	@Autowired
	public PessoaService(PessoaRepository repository) {
		this.repository = repository;
	}

	public void salvar(PessoaRequest request) {

		// mapeamento
		Pessoa pessoa = new Pessoa();
		pessoa.setCpf(request.getCpf());
		pessoa.setNome(request.getNome());

		repository.save(pessoa);
	}

	public List<Pessoa> listar() {
		return repository.findAll();
	}

	public Optional<Pessoa> find(String cpf) {
		return repository.findByCpf(cpf);
	}

	public Pessoa load(String cpf) {
		return this.find(cpf)
			.orElseThrow(() -> new NotFoundException("Pessoa não encontrada"));
	}

	public void delete(String cpf) {

		Pessoa pessoa = repository.findByCpf(cpf) // param hint
			.orElseThrow(() -> new NotFoundException("Pessoa não encontrada"));

		repository.delete(pessoa);

		// if (pessoa.isPresent()) {
		// } else {
		// 	throw NotFoundException("Pessoa com o CPF %s não foi encontrada");
		// }
	}

	public void update(UUID uuid, @Valid PessoaRequest body) {

		Pessoa pessoa = repository.findById(uuid)
				.orElseThrow(() -> new NotFoundException("Pessoa não encontrada"));

		// mapeamento
		pessoa.setNome(body.getNome());
		// pessoa.setCpf(body.getCpf());

		repository.save(pessoa);
	}

}
