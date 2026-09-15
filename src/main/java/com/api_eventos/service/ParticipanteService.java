package com.api_eventos.service;

import com.api_eventos.config.RecursoDuplicadoException;
import com.api_eventos.dto.ParticipanteRequestDTO;
import com.api_eventos.dto.ParticipanteResponseDTO;
import com.api_eventos.model.Participante;
import com.api_eventos.repository.ParticipanteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipanteService {

    private final ParticipanteRepository participanteRepository;

    public ParticipanteService(ParticipanteRepository participanteRepository) {
        this.participanteRepository = participanteRepository;
    }

    public List<ParticipanteResponseDTO> listar() {
        return participanteRepository.findAll().stream().map(this::toResponse).toList();
    }

    public ParticipanteResponseDTO create(ParticipanteRequestDTO dto) {
        if (participanteRepository.existsByEmail(dto.email())) {
            throw new RecursoDuplicadoException("Já existe um participante com este e-mail.");
        }

        Participante participante = new Participante();
        participante.setNome(dto.nome());
        participante.setEmail(dto.email());

        Participante savedParticipante = participanteRepository.save(participante);

        return toResponse(savedParticipante);
    }

    private ParticipanteResponseDTO toResponse(Participante participante) {
        return ParticipanteResponseDTO.builder()
                .id(participante.getId())
                .nome(participante.getNome())
                .email(participante.getEmail())
                .build();
    }
}
