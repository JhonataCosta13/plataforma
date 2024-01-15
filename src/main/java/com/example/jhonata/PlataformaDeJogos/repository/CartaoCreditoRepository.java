package com.example.jhonata.PlataformaDeJogos.repository;

import com.example.jhonata.PlataformaDeJogos.model.CartaoCredito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoCreditoRepository extends JpaRepository<CartaoCredito, Long> {
}
