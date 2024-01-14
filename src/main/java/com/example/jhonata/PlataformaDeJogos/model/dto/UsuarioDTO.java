package com.example.jhonata.PlataformaDeJogos.model.dto;

import com.example.jhonata.PlataformaDeJogos.model.Carteira;
import com.example.jhonata.PlataformaDeJogos.model.Jogo;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class UsuarioDTO {

    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private String nomeUsuario;
    private String email;
    private List<Jogo> jogos;
    private Carteira carteira;
}
