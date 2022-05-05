package br.edu.ifrs.riogrande.tads.carloslucas.app.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

// mapear a classe à tabela, e as instâncias às rows (ORM)
@Entity
@Table(name = "users")
public class User { // Entidade: Classe -> Tabela (JPA)

	@Id
	@GeneratedValue
	private UUID id;

	@Column(name = "cpf", length = 11, nullable = false, unique = true)
	private String cpf; // chave

	@Column(name = "name", length = 100, nullable = false)
	private String name;

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getId() {
		return id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Pessoa #" + id + " " + cpf + " " + name;
	}

}
