package com.questionnaire.mysql;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Cursos")
public class Cursos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
    @NotNull
    @NotEmpty
    @Column(name = "categoria")
	private String categoria;
	
	@NotBlank
    @NotNull
    @NotEmpty
    @Column(name = "link")
	private String link;
	
	@NotBlank
    @NotNull
    @NotEmpty
    @Column(name = "descricCurso")
	private String DescricaoCurso;
	
	@Min(1)
	@Max(10)
    @Column(name = "nivel")
	private int nivel;
	
	@NotBlank
    @NotNull
    @NotEmpty
    @Column(name = "imagemLocal")
	private String LocalImagem;

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescricaoCurso() {
		return DescricaoCurso;
	}

	public void setDescricaoCurso(String descricaoCurso) {
		DescricaoCurso = descricaoCurso;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLocalImagem() {
		return LocalImagem;
	}

	public void setLocalImagem(String localImagem) {
		LocalImagem = localImagem;
	}

	public Cursos(@NotBlank @NotNull @NotEmpty String categoria, @NotBlank @NotNull @NotEmpty String link,
			@NotBlank @NotNull @NotEmpty String descricaoCurso, @Min(1) @Max(10) int nivel,
			@NotBlank @NotNull @NotEmpty String localImagem) {
		super();
		this.categoria = categoria;
		this.link = link;
		DescricaoCurso = descricaoCurso;
		this.nivel = nivel;
		LocalImagem = localImagem;
	}
	
	public Cursos() {
		
	}

	
	
	
}


	