package com.questionnaire.controlers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.questionnaire.mysql.Usuarios;
import com.questionnaire.repositories.UsuariosRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    
    @Autowired
    private UsuariosRepository cursoRepository;
    
    @GetMapping
    public List<Usuarios> getCursos() {
        return cursoRepository.findAll();
    }
    
    @PostMapping("/create")
    public ResponseEntity<Usuarios> createCurso(@Valid @RequestBody Usuarios usuarios) {
        Usuarios savedCurso = cursoRepository.save(usuarios);
        return new ResponseEntity<>(savedCurso, HttpStatus.CREATED);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Usuarios>> getCursoById(@PathVariable Long id) {
        Optional<Usuarios> usuario = cursoRepository.findById(id);
        if (usuario == null) {
            throw new ResourceNotFoundException("Curso não encontrado com o ID: " + id);
        }
        return ResponseEntity.ok(usuario);
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<Usuarios> updateCurso(@PathVariable Long id, @Valid @RequestBody Usuarios cursoDetails) {
    	Usuarios usuario = cursoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado com o ID: " + id));

        usuario.setData(cursoDetails.getData());
        usuario.setNome(cursoDetails.getNome());
        usuario.setNomeGit(cursoDetails.getNomeGit());
       
        
        Usuarios updatedCurso = cursoRepository.save(usuario);
        return ResponseEntity.ok(updatedCurso);
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurso(@PathVariable Long id) {
    	Usuarios usuarios = cursoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado com o ID: " + id));
        
        cursoRepository.delete(usuarios);
        return ResponseEntity.noContent().build();
    }
}
