package com.example.jhonata.PlataformaDeJogos.controller;

import com.example.jhonata.PlataformaDeJogos.model.Usuario;
import com.example.jhonata.PlataformaDeJogos.model.dto.JogoInputDTO;
import com.example.jhonata.PlataformaDeJogos.model.dto.UsuarioDTO;
import com.example.jhonata.PlataformaDeJogos.model.dto.UsuarioInputDTO;
import com.example.jhonata.PlataformaDeJogos.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<?> criarUsuario(@RequestBody @Valid UsuarioInputDTO usuarioInput){

        Usuario usuarioOutput = usuarioService.saveUsuario(usuarioInput);
        URI location = UriComponentsBuilder.
                fromUriString("http://localhost:8080/usuario/{id}").
                buildAndExpand(usuarioOutput.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> buscarUsuarios(){
        List<UsuarioDTO> usuarios = usuarioService.getAll();
        return ResponseEntity.ok().body(usuarios);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> addJogo(@PathVariable("id") Long id, @RequestBody JogoInputDTO jogoInputDTO){
        UsuarioDTO usuarioDTO = usuarioService.adicionarJogos(id, jogoInputDTO);
        return ResponseEntity.ok().body(usuarioDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> buscarUsuario(@PathVariable("id") Long id){
        UsuarioDTO usuario = usuarioService.getUsuarioById(id);
        return ResponseEntity.ok().body(usuario);
    }
}
