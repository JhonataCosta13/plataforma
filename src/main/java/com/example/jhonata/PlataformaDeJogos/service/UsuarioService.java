package com.example.jhonata.PlataformaDeJogos.service;

import com.example.jhonata.PlataformaDeJogos.model.Jogo;
import com.example.jhonata.PlataformaDeJogos.model.Usuario;
import com.example.jhonata.PlataformaDeJogos.model.dto.JogoInputDTO;
import com.example.jhonata.PlataformaDeJogos.model.dto.UsuarioDTO;
import com.example.jhonata.PlataformaDeJogos.model.dto.UsuarioInputDTO;
import com.example.jhonata.PlataformaDeJogos.repository.UsuarioRepository;
import com.example.jhonata.PlataformaDeJogos.service.exception.NegocioExeption;
import com.example.jhonata.PlataformaDeJogos.service.exception.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JogoService jogoService;

    @Autowired
    private CartaoCreditoService cartaoCreditoService;

    @Autowired
    private ModelMapper modelMapper;


    public Usuario saveUsuario(UsuarioInputDTO usuarioInputDTO) {
        if(usuarioInputDTO.getNome().equals("puta")){
            throw new NegocioExeption("Nome Imprópio");
        }
        Usuario usuarioInput = modelMapper.map(usuarioInputDTO, Usuario.class);
        usuarioRepository.save(usuarioInput);
        cartaoCreditoService.salvarCartaoNaCarteira(usuarioInput.getCarteira().getCartaoCreditos(), usuarioInput.getCarteira());
        return usuarioInput;
    }

    public List<UsuarioDTO> getAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioDTO> usuariosDTO;
        usuariosDTO = usuarios.stream().map(u -> modelMapper.map(u, UsuarioDTO.class)).toList();
        return usuariosDTO;
    }

    public UsuarioDTO adicionarJogos(Long id, JogoInputDTO usuarioIds) {
        Usuario usuario = usuarioRepository.findById(id).get();
        List<Jogo> jogos = jogoService.buscarJogoPorId(usuarioIds.getJogoIds().stream().toList());
        jogoService.vinculaUsuario(jogos, usuario);
        usuario.setJogos(jogos);
        usuario = usuarioRepository.save(usuario);
        return modelMapper.map(usuario, UsuarioDTO.class);
    }

    public UsuarioDTO getUsuarioById(Long id) {
        Usuario usuario = usuarioRepository.findById(id).
                orElseThrow( () -> new ObjectNotFoundException("Usuário Não Encontrado. ID: "+ id));
        return modelMapper.map(usuario, UsuarioDTO.class);
    }
}
