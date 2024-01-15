package com.example.jhonata.PlataformaDeJogos.repository;


import com.example.jhonata.PlataformaDeJogos.model.Carteira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarteiraRepository extends JpaRepository<Carteira, Long> {
}
