package com.example.jhonata.PlataformaDeJogos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeJogo;

    @ManyToMany
    @JoinTable(
            name = "jogo-usuario",
            joinColumns = @JoinColumn(name = "jogo_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
   @JsonIgnore
    private List<Usuario> usuarios;

    public void addUsuario(Usuario usuario) {
        if(this.usuarios == null){
            this.usuarios = new ArrayList<>();
        }
        this.usuarios.add(usuario);
    }
}
