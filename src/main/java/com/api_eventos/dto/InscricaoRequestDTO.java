package com.api_eventos.dto;


import com.api_eventos.model.Evento;
import com.api_eventos.model.Inscricao;
import com.api_eventos.model.Participante;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record InscricaoRequestDTO(
        Long eventoId,
        Long participanteId,
        LocalDate dataInscricao

) {

}
