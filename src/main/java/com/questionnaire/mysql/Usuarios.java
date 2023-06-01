
package com.questionnaire.mysql;

import java.time.LocalDate;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Usuarios")
public class Usuarios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@NotBlank
	@NotNull
	@NotEmpty
	@Column(name = "nome")
	private String nome;
	
	@NotBlank
	@NotNull
	@NotEmpty
	@Column(name = "nomeGit")
	private String NomeGit;
	
	
	@NotNull(message = "está nulo!")
	@Column(name = "data")
	private LocalDate data;

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeGit() {
		return NomeGit;
	}

	public void setNomeGit(String nomeGit) {
		NomeGit = nomeGit;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Usuarios(@NotBlank @NotNull @NotEmpty String nome, @NotBlank @NotNull @NotEmpty String nomeGit,
			@NotBlank @NotNull @NotEmpty LocalDate data) {
		this.nome = nome;
		NomeGit = nomeGit;
		this.data = data;
	}

	public Usuarios() {
	
	}
	
	
	
	
	
	
	

}
