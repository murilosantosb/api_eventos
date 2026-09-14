package com.api_eventos.service;

import com.api_eventos.repository.ParticipanteRepository;
import org.springframework.stereotype.Service;

@Service
public class ParticipanteService {

    private final ParticipanteRepository participanteRepository;

    public ParticipanteService(ParticipanteRepository participanteRepository) {
        this.participanteRepository = participanteRepository;
    }


}
