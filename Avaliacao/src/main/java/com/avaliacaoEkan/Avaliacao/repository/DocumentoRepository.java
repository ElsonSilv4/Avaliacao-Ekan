package com.avaliacaoEkan.Avaliacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.avaliacaoEkan.Avaliacao.model.Documento;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {

	public List<Documento> findAllByDescricaoContainingIgnoreCase(@Param("descricao") String descricao);
	
}
