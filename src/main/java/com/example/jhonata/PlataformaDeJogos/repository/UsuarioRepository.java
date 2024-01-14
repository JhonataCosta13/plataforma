package com.example.jhonata.PlataformaDeJogos.repository;

import com.example.jhonata.PlataformaDeJogos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
}
