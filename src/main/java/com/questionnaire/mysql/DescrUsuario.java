package com.questionnaire.mysql;

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
@Table(name = "DescUsuarios")
public class DescrUsuario {

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
    @Column(name = "linguagem")
    private String Linguagem;

    @NotBlank
    @NotNull
    @NotEmpty
    @Column(name = "nivel")
    private String nivel;

    @NotBlank
    @NotNull
    @NotEmpty
    @Column(name = "opiniao")
    private String opiniao;

    @Column(name = "idade")
    private int idade;

    @NotBlank
    @NotNull
    @NotEmpty
    @Column(name = "gmail")
    private String gmail;

    @NotBlank
    @NotNull
    @NotEmpty
    @Column(name = "github")
    private String github;

    public DescrUsuario() {
       
    }


    public String getLinguagem() {
        return Linguagem;
    }

    public void setLinguagem(String linguagem) {
        Linguagem = linguagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getOpiniao() {
        return opiniao;
    }

    public void setOpiniao(String opiniao) {
        this.opiniao = opiniao;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public DescrUsuario(@NotBlank @NotNull @NotEmpty String nome, @NotBlank @NotNull @NotEmpty String linguagem,
            @NotBlank @NotNull @NotEmpty String nivel, @NotBlank @NotNull @NotEmpty String opiniao,
            @NotBlank @NotNull @NotEmpty int idade, @NotBlank @NotNull @NotEmpty String gmail,
            @NotBlank @NotNull @NotEmpty String github) {
        super();
        this.nome = nome;
        Linguagem = linguagem;
        this.nivel = nivel;
        this.opiniao = opiniao;
        this.idade = idade;
        this.gmail = gmail;
        this.github = github;
    }

	
    
   

}
