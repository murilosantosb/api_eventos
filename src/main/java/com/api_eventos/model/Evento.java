package com.api_eventos.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Evento {
    private Long id;
    private String nome;
    private String descricao;
    private LocalDateTime data;
    private Integer capacidadeMaxima;

}
