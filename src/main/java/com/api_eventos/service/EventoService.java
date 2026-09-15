package com.api_eventos.service;

import com.api_eventos.config.RecursoNaoEncontradoException;
import com.api_eventos.dto.EventoRequestDTO;
import com.api_eventos.dto.EventoResponseDTO;
import com.api_eventos.model.Evento;
import com.api_eventos.repository.EventoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {

    private final EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public EventoResponseDTO criar (EventoRequestDTO eventoRequestDTO){
        Evento evento = Evento. builder()
                .nome(eventoRequestDTO.nome())
                .descricao(eventoRequestDTO.descricao())
                .data(eventoRequestDTO.data())
                .capacidadeMaxima(eventoRequestDTO.capacidadeMaxima()).build();

        Evento salvo = eventoRepository.save(evento);

        return toResponseDTO(salvo);

    }

    public List<EventoResponseDTO> listar (){
        return eventoRepository.findAll().stream().map(this::toResponseDTO).toList();
    }

    public EventoResponseDTO buscarPorId(Long id){
        return  toResponseDTO(eventoRepository.findById(id).orElseThrow(()-> new RecursoNaoEncontradoException("Usuário não encontrado")));
    }

    private EventoResponseDTO toResponseDTO (Evento evento){
        return EventoResponseDTO.builder()
                .id(evento.getId())
                .nome(evento.getNome())
                .descricao(evento.getDescricao())
                .data(evento.getData())
                .capacidadeMaxima(evento.getCapacidadeMaxima()).build();
    }


}
