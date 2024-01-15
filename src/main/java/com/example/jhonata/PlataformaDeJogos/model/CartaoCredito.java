package com.example.jhonata.PlataformaDeJogos.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class CartaoCredito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer codSeguranca;
    private String numeroCartao;

    @ManyToOne
    @JoinColumn(name = "carteira_id")
    private Carteira carteira;
}
