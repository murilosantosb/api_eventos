package com.api_eventos.repository;


import com.api_eventos.model.Inscricao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {
}
