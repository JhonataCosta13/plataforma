package com.example.jhonata.PlataformaDeJogos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carteira_id")
    private Carteira carteira;

}
