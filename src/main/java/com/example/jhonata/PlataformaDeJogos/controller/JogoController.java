package com.example.jhonata.PlataformaDeJogos.controller;

import com.example.jhonata.PlataformaDeJogos.model.Jogo;
import com.example.jhonata.PlataformaDeJogos.service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("jogo")
public class JogoController {

    @Autowired
    private JogoService jogoService;

    @PostMapping
    public ResponseEntity<?> criarJogo(@RequestBody Jogo jogoInput) {

        Jogo jogoOutput = jogoService.saveJogo(jogoInput);
        URI location = UriComponentsBuilder.
                fromUriString("http://localhost:8080/jogo/{id}").
                buildAndExpand(jogoOutput.getId()).toUri();

        return ResponseEntity.created(location).build();

    }
}
