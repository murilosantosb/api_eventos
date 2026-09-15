package com.api_eventos.controller;

import com.api_eventos.dto.InscricaoRequestDTO;
import com.api_eventos.dto.InscricaoResponseDTO;
import com.api_eventos.service.InscricaoService;
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
    public InscricaoResponseDTO inscrever (@RequestBody InscricaoRequestDTO inscricaoRequestDTO){
        return inscricaoService.inscrever(inscricaoRequestDTO);
    }

    @GetMapping("pessoas/{id}")
    public List<InscricaoResponseDTO> listar(@PathVariable Long id) {
        return inscricaoService.listar(id);
    }


}
