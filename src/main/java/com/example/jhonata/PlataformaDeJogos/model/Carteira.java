package com.example.jhonata.PlataformaDeJogos.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Carteira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float fundos;

    @OneToMany(mappedBy = "carteira")
    private List<CartaoCredito> cartaoCreditos;

}
