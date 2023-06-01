package com.questionnaire;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.questionnaire.mysql.Cursos;
import com.questionnaire.mysql.DescrUsuario;
import com.questionnaire.mysql.Usuarios;
import com.questionnaire.repositories.CursosRepository;
import com.questionnaire.repositories.DescUsuarioRepository;
import com.questionnaire.repositories.UsuariosRepository;

@SpringBootApplication
public class QuestionnaireApplication implements CommandLineRunner {
	
	
	@Autowired
	UsuariosRepository repository;
	
	@Autowired
	DescUsuarioRepository descUsuarioRepository;
	
	@Autowired
	CursosRepository  cursosRepository;

	public static void main(String[] args) {
		SpringApplication.run(QuestionnaireApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		//teste usuario
		 Usuarios usuarios = new Usuarios("igor", "igor-de-campos", data );
	   repository.save(usuarios);
	   
	   //teste Descricao usuario
	      DescrUsuario descrUsuario = new DescrUsuario("José lopes", "java", "profissional", "boa", 27,
			   "igorccampos9@gmail.com", "https://github.com/Igor-de-campos");
       descUsuarioRepository.save(descrUsuario);
       
       //test Cursos
       Cursos curso = new Cursos("Programacao java", "https://www.udemy.com/course/desenvolva-aplicacoes-completas-com-spring-boot-e-react-js/", "Spring Boot + React JS: Desenvolva Aplicações Web Completas\n"
       	+ "Curso Full Stack com Spring Boot e React JS, do zero à nuvem.", 7, "src/png/image.png");
       
       cursosRepository.save(curso);
	}
	
	///teste da data
	 int dia = 27;
     int mes = 5;
     int ano = 2023;

     LocalDate data = LocalDate.of(ano, mes, dia);
}
