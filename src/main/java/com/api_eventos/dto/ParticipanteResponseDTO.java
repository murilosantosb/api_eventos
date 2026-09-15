package com.api_eventos.dto;

import lombok.Builder;


@Builder

public record ParticipanteResponseDTO(
        Long id,
        String nome,
        String email
){

}
