package com.api_eventos.controller;

import com.api_eventos.dto.EventoRequestDTO;
import com.api_eventos.dto.EventoResponseDTO;
import com.api_eventos.service.EventoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evento")
public class EventoController {

    private final EventoService eventoService;


    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @PostMapping()
    public ResponseEntity<EventoResponseDTO> criar (@RequestBody EventoRequestDTO eventoRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(eventoService.criar(eventoRequestDTO));
    }

    @GetMapping
    public ResponseEntity<List<EventoResponseDTO>> listar(){
        return ResponseEntity.ok(eventoService.listar());
    }

    @GetMapping("{id}")
    public ResponseEntity<EventoResponseDTO> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(eventoService.buscarPorId(id));
    }


}
