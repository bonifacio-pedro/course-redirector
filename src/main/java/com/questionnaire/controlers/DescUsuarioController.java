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

import com.questionnaire.mysql.DescrUsuario;
import com.questionnaire.repositories.DescUsuarioRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/desUsuario")
public class DescUsuarioController {
    
    @Autowired
    private DescUsuarioRepository cursoRepository;
    
    @GetMapping
    public List<DescrUsuario> getCursos() {
        return cursoRepository.findAll();
    }
    
    @PostMapping("/create")
    public ResponseEntity<DescrUsuario> createCurso(@Valid @RequestBody DescrUsuario usuario) {
    	DescrUsuario savedUsuario = cursoRepository.save(usuario);
        return new ResponseEntity<>(savedUsuario, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Optional<DescrUsuario>> getCursoById(@PathVariable Long id) {
        Optional<DescrUsuario> DescUsuario = cursoRepository.findById(id);
        if (DescUsuario == null) {
            throw new ResourceNotFoundException("Curso não encontrado com o ID: " + id);
        }
        return ResponseEntity.ok(DescUsuario);
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<DescrUsuario> updateCurso(@PathVariable Long id, @Valid @RequestBody DescrUsuario cursoDetails) {
    	DescrUsuario descrUsuario = cursoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado com o ID: " + id));

       
         descrUsuario.setOpiniao(cursoDetails.getOpiniao());
        descrUsuario.setNome(cursoDetails.getNome());
        descrUsuario.setNivel(cursoDetails.getNivel());
        descrUsuario.setLinguagem(cursoDetails.getLinguagem());
        descrUsuario.setIdade(cursoDetails.getIdade());
        descrUsuario.setGmail(cursoDetails.getGmail());
        descrUsuario.setGithub(cursoDetails.getGithub());
       
       
        
        DescrUsuario updatedCurso = cursoRepository.save(descrUsuario);
        return ResponseEntity.ok(updatedCurso);
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurso(@PathVariable Long id) {
        DescrUsuario DescUsuario = cursoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado com o ID: " + id));
        
        cursoRepository.delete(DescUsuario);
        return ResponseEntity.noContent().build();
    }
}
