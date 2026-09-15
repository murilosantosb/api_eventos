package com.api_eventos.controller;

import com.api_eventos.dto.InscricaoRequestDTO;
import com.api_eventos.dto.InscricaoResponseDTO;
import com.api_eventos.service.InscricaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inscricoes")
public class InscricaoController {

    private final InscricaoService inscricaoService;

    public InscricaoController(InscricaoService inscricaoService) {
        this.inscricaoService = inscricaoService;
    }

    @PostMapping
    public ResponseEntity<InscricaoResponseDTO> inscrever (@RequestBody InscricaoRequestDTO inscricaoRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(inscricaoService.inscrever(inscricaoRequestDTO));
    }

    @GetMapping("pessoas/{id}")
    public ResponseEntity<List<InscricaoResponseDTO>> listar(@PathVariable Long id) {
        return ResponseEntity.ok(inscricaoService.listar(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> cancelar(@PathVariable Long id){
        inscricaoService.cancelar(id);
        return ResponseEntity.noContent().build();
    }

}
