package com.example.jhonata.PlataformaDeJogos.repository;

import com.example.jhonata.PlataformaDeJogos.model.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {
}
