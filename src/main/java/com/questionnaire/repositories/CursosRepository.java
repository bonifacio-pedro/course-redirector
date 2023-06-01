package com.questionnaire.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.questionnaire.mysql.Cursos;

public interface CursosRepository extends JpaRepository<Cursos, Integer> {

	
	 Optional<Cursos> findById(Long id);
}

