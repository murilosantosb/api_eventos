package com.api_eventos.controller;

import com.api_eventos.dto.ParticipanteRequestDTO;
import com.api_eventos.dto.ParticipanteResponseDTO;
import com.api_eventos.model.Participante;
import com.api_eventos.service.ParticipanteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/participante")
public class ParticipanteController {

    private final ParticipanteService participanteService;

    public ParticipanteController(ParticipanteService participanteService) {
        this.participanteService = participanteService;
    }

    @GetMapping
    public ResponseEntity<List<ParticipanteResponseDTO>> listar() {
        return ResponseEntity.ok(participanteService.listar());
    }

    @PostMapping
    public ResponseEntity<ParticipanteResponseDTO> create(@RequestBody ParticipanteRequestDTO dto) {
            ParticipanteResponseDTO saved = participanteService.create(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
