package com.api_eventos.controller;

import com.api_eventos.dto.ParticipanteDTO;
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
    public ResponseEntity<List<Participante>> listar() {
        return ResponseEntity.ok(participanteService.listar());
    }

    @PostMapping
    public ResponseEntity<ParticipanteDTO> create(@RequestBody ParticipanteDTO dto) {
            ParticipanteDTO saved = participanteService.create(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
