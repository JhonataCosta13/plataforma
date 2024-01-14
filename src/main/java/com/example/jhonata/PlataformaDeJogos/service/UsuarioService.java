package com.example.jhonata.PlataformaDeJogos.service;

import com.example.jhonata.PlataformaDeJogos.model.Jogo;
import com.example.jhonata.PlataformaDeJogos.model.Usuario;
import com.example.jhonata.PlataformaDeJogos.model.dto.JogoInputDTO;
import com.example.jhonata.PlataformaDeJogos.model.dto.UsuarioDTO;
import com.example.jhonata.PlataformaDeJogos.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired JogoService jogoService;

    @Autowired
    private ModelMapper modelMapper;

    public Usuario saveUsuario(Usuario usuarioInput) {
        return usuarioRepository.save(usuarioInput);
    }

    public List<UsuarioDTO> getAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioDTO> usuariosDTO;
        usuariosDTO = usuarios.stream().map(u -> modelMapper.map(u, UsuarioDTO.class)).toList();
        return usuariosDTO;
    }

    public Usuario adicionarJogos(Long id, JogoInputDTO usuarioIds) {
        Usuario usuario = usuarioRepository.findById(id).get();
        List<Jogo> jogos = jogoService.buscarJogoPorId(usuarioIds.getJogoIds().stream().toList());
        jogoService.vinculaUsuario(jogos, usuario);
        usuario.setJogos(jogos);
        return usuarioRepository.save(usuario);
    }
}
