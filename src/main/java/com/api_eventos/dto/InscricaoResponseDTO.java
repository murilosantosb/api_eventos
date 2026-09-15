package com.api_eventos.dto;

import com.api_eventos.model.Evento;
import com.api_eventos.model.Participante;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record InscricaoResponseDTO(
        Long id,
        Long EventoId,
        Long ParticipanteId,
        LocalDate dataInscricao
) {

}
