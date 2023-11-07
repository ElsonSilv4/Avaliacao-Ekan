package com.avaliacaoEkan.Avaliacao.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.avaliacaoEkan.Avaliacao.model.Documento;
import com.avaliacaoEkan.Avaliacao.repository.DocumentoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/documentos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DocumentoController {

	@Autowired
	private DocumentoRepository documentoRepository;
	
	@GetMapping
	public ResponseEntity<List<Documento>>getAll(){
		return ResponseEntity.ok(documentoRepository.findAll());
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<Documento> getById(@PathVariable Long id){
        return documentoRepository.findById(id)
            .map(resposta -> ResponseEntity.ok(resposta))
            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
	
	@GetMapping("/descricao/{descricao}")
    public ResponseEntity<List<Documento>> getByTitle(@PathVariable 
    String descricao){
        return ResponseEntity.ok(documentoRepository
            .findAllByDescricaoContainingIgnoreCase(descricao));
    }
	
	@PostMapping
    public ResponseEntity<Documento> post(@Valid @RequestBody Documento documento){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(documentoRepository.save(documento));
    }
	
	 @PutMapping
	    public ResponseEntity<Documento> put(@Valid @RequestBody Documento documento){
	        return documentoRepository.findById(documento.getId())
	            .map(resposta -> ResponseEntity.status(HttpStatus.CREATED)
	            .body(documentoRepository.save(documento)))
	            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	    }
	
	 @ResponseStatus(HttpStatus.NO_CONTENT)
	    @DeleteMapping("/{id}")
	    public void delete(@PathVariable Long id) {
	        Optional<Documento> documento = documentoRepository.findById(id);
	        
	        if(documento.isEmpty())
	            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	        
	        documentoRepository.deleteById(id);              
	    }
	
}
