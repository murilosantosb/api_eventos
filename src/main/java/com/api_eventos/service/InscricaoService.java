package com.api_eventos.service;

import com.api_eventos.config.LimiteVagaException;
import com.api_eventos.config.RecursoDuplicadoException;
import com.api_eventos.config.RecursoNaoEncontradoException;
import com.api_eventos.dto.EventoResponseDTO;
import com.api_eventos.dto.InscricaoRequestDTO;
import com.api_eventos.dto.InscricaoResponseDTO;
import com.api_eventos.model.Evento;
import com.api_eventos.model.Inscricao;
import com.api_eventos.model.Participante;
import com.api_eventos.repository.EventoRepository;
import com.api_eventos.repository.InscricaoRepository;
import com.api_eventos.repository.ParticipanteRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class InscricaoService {

    private final InscricaoRepository inscricaoRepository;
    private final EventoRepository eventoRepository;
    private final ParticipanteRepository participanteRepository;

    public InscricaoService(InscricaoRepository inscricaoRepository, EventoRepository eventoRepository, ParticipanteRepository participanteRepository) {
        this.inscricaoRepository = inscricaoRepository;
        this.eventoRepository = eventoRepository;
        this.participanteRepository = participanteRepository;
    }

    public InscricaoResponseDTO inscrever(@RequestBody InscricaoRequestDTO inscricaoRequestDTO){

        Evento evento = eventoRepository.findById(inscricaoRequestDTO.eventoId()).orElseThrow(()-> new RecursoNaoEncontradoException("Evento não encontrado"));
        Participante participante = participanteRepository.findById(inscricaoRequestDTO.participanteId()).orElseThrow(() -> new RecursoNaoEncontradoException("Participante não encontrado"));

        if (evento.getCapacidadeMaxima() < 0) {
            throw new LimiteVagaException("Capacidade maxima alcançada");
        }

        if ( participante.getInscricoes().stream().anyMatch(idInscricao-> idInscricao.getEvento().getId().equals(evento.getId()))){
            throw new RecursoDuplicadoException("Inscrição duplicada");
        }


        evento.setCapacidadeMaxima(evento.getCapacidadeMaxima()-1);

        Inscricao inscricao = Inscricao.builder()
                .evento(evento)
                .participante(participante)
                .dataInscricao(inscricaoRequestDTO.dataInscricao()).build();

        return toResponseDTO(inscricaoRepository.save(inscricao));
    }

    public List<InscricaoResponseDTO> listar(Long id){
        Evento evento = eventoRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Evento não encontrado."));
        List<Inscricao>inscricoes= inscricaoRepository.findAll().stream().filter(i -> i.getEvento() == evento).toList();
        return inscricoes.stream().map(this::toResponseDTO).toList();
    }

    public void cancelar (Long id){

        Inscricao inscricao =inscricaoRepository.findById(id).orElseThrow(()-> new RuntimeException("id não encontrado"));

        Evento evento = eventoRepository.findById(inscricao.getEvento().getId()).orElseThrow(()-> new RuntimeException("Evento não encontrado"));

        evento.setCapacidadeMaxima(evento.getCapacidadeMaxima()+1);

        inscricaoRepository.deleteById(id);
    }

    private InscricaoResponseDTO toResponseDTO (Inscricao inscricao){
        return InscricaoResponseDTO.builder()
                .id(inscricao.getId())
                .ParticipanteId(inscricao.getParticipante().getId()).EventoId(inscricao.getEvento().getId())
                .dataInscricao(inscricao.getDataInscricao())
                .build();
    }

}
