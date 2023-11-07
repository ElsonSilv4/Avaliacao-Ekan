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

import com.avaliacaoEkan.Avaliacao.model.Beneficiario;
import com.avaliacaoEkan.Avaliacao.repository.BeneficiarioRepository;
import com.avaliacaoEkan.Avaliacao.repository.DocumentoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/beneficiario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BeneficiarioController {

	@Autowired
	private BeneficiarioRepository beneficiarioRepository;
	
	@Autowired
	private DocumentoRepository documentoRepository;

	@GetMapping
	public ResponseEntity<List<Beneficiario>> getAll() {
		return ResponseEntity.ok(beneficiarioRepository.findAll());
	}

	@PostMapping
	public ResponseEntity<Beneficiario> post(@Valid @RequestBody Beneficiario beneficiario) {
		if (documentoRepository.existsById(beneficiario.getDocumento().getId()))
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(beneficiarioRepository.save(beneficiario));
		
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Documento não existe!", null);
	} 

	@GetMapping ("/{id}")
	public ResponseEntity<Beneficiario> getById(@PathVariable Long id) {
		return beneficiarioRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@PutMapping
	public ResponseEntity<Beneficiario> put(@Valid @RequestBody Beneficiario beneficiario) {
		if (beneficiarioRepository.existsById(beneficiario.getId())) {
			if(documentoRepository.existsById(beneficiario.getDocumento().getId()))
				return ResponseEntity.status(HttpStatus.OK)
						.body(beneficiarioRepository.save(beneficiario));
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Documento não existe!", null);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Beneficiario> beneficiario = beneficiarioRepository.findById(id);
		
		if(beneficiario.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		beneficiarioRepository.deleteById(id);
	}
	
	
	
	
	
}
