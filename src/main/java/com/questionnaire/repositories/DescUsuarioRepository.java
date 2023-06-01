package com.questionnaire.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.questionnaire.mysql.DescrUsuario;

public interface DescUsuarioRepository extends JpaRepository<DescrUsuario, Integer> {
	Optional<DescrUsuario> findById(Long id);
}

