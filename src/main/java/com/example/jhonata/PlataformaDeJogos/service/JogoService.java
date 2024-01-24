package com.example.jhonata.PlataformaDeJogos.service;

import com.example.jhonata.PlataformaDeJogos.model.Jogo;
import com.example.jhonata.PlataformaDeJogos.model.Usuario;
import com.example.jhonata.PlataformaDeJogos.repository.JogoRepository;
import com.example.jhonata.PlataformaDeJogos.service.exception.JogoDuplicadoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class JogoService {

    @Autowired
    private JogoRepository jogoRepository;

    public Jogo saveJogo(Jogo jogoInput) {
        List<Jogo> duplicado = jogoRepository.findAll();

        for(Jogo jogo : duplicado){
            if(Objects.equals(jogoInput.getNomeJogo(), jogo.getNomeJogo())){
                throw new JogoDuplicadoException("Já existe um jogo com esse nome");
            }
        }

        return jogoRepository.save(jogoInput);
    }

    public List<Jogo> buscarJogoPorId(List<Long> jogoIds) {
        return jogoRepository.findAllById(jogoIds);
    }

    public void vinculaUsuario(List<Jogo> jogos, Usuario usuario) {
        for(Jogo jogo : jogos){
            jogo.addUsuario(usuario);
        }
        jogoRepository.saveAll(jogos);
    }
}
