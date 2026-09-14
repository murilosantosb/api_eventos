package com.api_eventos.service;

import com.api_eventos.dto.ParticipanteDTO;
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

    public List<Participante> listar() {
        return participanteRepository.findAll();
    }

    public ParticipanteDTO create(ParticipanteDTO dto) {
        if (participanteRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Já existe um participante com este e-mail.");
        }

        Participante participante = new Participante();
        participante.setNome(dto.getNome());
        participante.setEmail(dto.getEmail());

        Participante savedParticipante = participanteRepository.save(participante);

        return toResponse(savedParticipante);
    }

    private ParticipanteDTO toResponse(Participante participante) {
        return ParticipanteDTO.builder()
                .id(participante.getId())
                .nome(participante.getNome())
                .email(participante.getEmail())
                .build();
    }
}
