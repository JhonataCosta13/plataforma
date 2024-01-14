package com.example.jhonata.PlataformaDeJogos.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private LocalDate dataNascimento;
    private String nomeUsuario;
    private String email;
    private String senha;

    @ManyToMany(mappedBy = "usuarios")
    private List<Jogo> jogos;
}
