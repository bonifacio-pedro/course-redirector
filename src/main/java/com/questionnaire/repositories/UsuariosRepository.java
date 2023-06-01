package com.questionnaire.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.questionnaire.mysql.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios, Integer> {
	Optional<Usuarios> findById(Long id);
}

