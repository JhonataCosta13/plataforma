package com.example.jhonata.PlataformaDeJogos.model.dto;

import com.example.jhonata.PlataformaDeJogos.model.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import java.util.List;

public class JogoDTO {
    private Long id;
    private String nomeJogo;
}
