package com.api_eventos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
public record EventoResponseDTO(
        Long id,
        String nome,
        String descricao,
        LocalDateTime data,
        Integer capacidadeMaxima
) {
}
