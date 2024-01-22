package com.example.jhonata.PlataformaDeJogos.model.dto;

import com.example.jhonata.PlataformaDeJogos.model.Carteira;
import com.example.jhonata.PlataformaDeJogos.model.Jogo;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class UsuarioInputDTO {

    @NotNull(message = "O campo Nome é obrigatório.")
    @NotEmpty(message = "O campo Nome não pode estar vazio.")
    @NotBlank(message = "O campo Nome não pode estar em branco.")
    private String nome;

    private LocalDate dataNascimento;

    @NotEmpty(message = "O campo nome do usuário não pode estar vazio.")
    @Size(min = 3, max = 150, message = "O campo nome de usuário deve estar entre 5 e 150 caracteres.")
    private String nomeUsuario;

    @Email(message = "Por favor forneça um Email válido")
    @NotEmpty(message = "O campo Email não pode estar vazio.")
    @NotNull(message = "O campo Email é obrigatório.")
    private String email;

    @NotEmpty(message = "O campo Senha não pode estar vazio.")
    @NotNull(message = "O campo Senha é obrigatório.")
    private String senha;

    private Carteira carteira;
}
