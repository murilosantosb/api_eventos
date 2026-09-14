package com.api_eventos.controller;

import com.api_eventos.dto.EventoRequestDTO;
import com.api_eventos.dto.EventoResponseDTO;
import com.api_eventos.service.EventoService;
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
    public EventoResponseDTO criar (@RequestBody EventoRequestDTO eventoRequestDTO){
        return eventoService.criar(eventoRequestDTO);
    }

    @GetMapping
    public List<EventoResponseDTO> listar(){
        return eventoService.listar();
    }


    @GetMapping("{id}")
    public EventoResponseDTO buscarPorId(@PathVariable Long id){
        return eventoService.buscarPorId(id);
    }


}
