package com.example.jhonata.PlataformaDeJogos.service;

import com.example.jhonata.PlataformaDeJogos.model.CartaoCredito;
import com.example.jhonata.PlataformaDeJogos.model.Carteira;
import com.example.jhonata.PlataformaDeJogos.repository.CartaoCreditoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartaoCreditoService {

    @Autowired
    private CartaoCreditoRepository cartaoCreditoRepository;


    public void salvarCartaoNaCarteira(List<CartaoCredito> cartaoCreditos, Carteira carteira) {
        cartaoCreditos.stream().forEach(c -> c.setCarteira(carteira));
        cartaoCreditoRepository.saveAll(cartaoCreditos);
    }
}
