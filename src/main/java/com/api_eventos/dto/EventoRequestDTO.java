package com.api_eventos.dto;

import java.time.LocalDateTime;

public record EventoRequestDTO(
        String nome,
        String descricao,
        LocalDateTime data,
        Integer capacidadeMaxima
) {
}
