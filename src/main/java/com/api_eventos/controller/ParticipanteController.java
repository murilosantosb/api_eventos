package com.api_eventos.controller;

import com.api_eventos.dto.ParticipanteDTO;
import com.api_eventos.service.ParticipanteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/participante")
public class ParticipanteController {

    private final ParticipanteService participanteService;

    public ParticipanteController(ParticipanteService participanteService) {
        this.participanteService = participanteService;
    }

    @PostMapping
    public ResponseEntity<ParticipanteDTO> create(@RequestBody ParticipanteDTO dto) {
            ParticipanteDTO saved = participanteService.create(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
