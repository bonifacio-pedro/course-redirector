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

import com.questionnaire.mysql.Cursos;
import com.questionnaire.repositories.CursosRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    
    @Autowired
    private CursosRepository cursoRepository;
    
    @GetMapping
    public List<Cursos> getCursos() {
        return cursoRepository.findAll();
    }
    
    @PostMapping("/create")
    public ResponseEntity<Cursos> createCurso(@Valid @RequestBody Cursos curso) {
        Cursos savedCurso = cursoRepository.save(curso);
        return new ResponseEntity<>(savedCurso, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Cursos>> getCursoById(@PathVariable Long id) {
        Optional<Cursos> curso = cursoRepository.findById(id);
        if (curso == null) {
            throw new ResourceNotFoundException("Curso não encontrado com o ID: " + id);
        }
        return ResponseEntity.ok(curso);
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<Cursos> updateCurso(@PathVariable Long id, @Valid @RequestBody Cursos cursoDetails) {
        Cursos curso = cursoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado com o ID: " + id));

       
        curso.setCategoria(cursoDetails.getCategoria());
        curso.setLink(cursoDetails.getLink());
        curso.setDescricaoCurso(cursoDetails.getDescricaoCurso());
        curso.setNivel(cursoDetails.getNivel());
        curso.setLocalImagem(cursoDetails.getLocalImagem());
        
        Cursos updatedCurso = cursoRepository.save(curso);
        return ResponseEntity.ok(updatedCurso);
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurso(@PathVariable Long id) {
        Cursos curso = cursoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado com o ID: " + id));
        
        cursoRepository.delete(curso);
        return ResponseEntity.noContent().build();
    }
}
