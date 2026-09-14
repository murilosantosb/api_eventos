package com.api_eventos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
public class Evento {
    private Long id;

    @Column(nullable = false)
    private String nome;
    private String descricao;

    @Column(nullable = false)
    private LocalDateTime data;

    @Column(nullable = false)
    private Integer capacidadeMaxima;

}
