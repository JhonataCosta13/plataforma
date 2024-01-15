package com.example.jhonata.PlataformaDeJogos.service;

import com.example.jhonata.PlataformaDeJogos.model.Carteira;
import com.example.jhonata.PlataformaDeJogos.model.Usuario;
import com.example.jhonata.PlataformaDeJogos.repository.CarteiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class CarteiraService {

    @Autowired
    private CarteiraRepository carteiraRepository;

    @Autowired CartaoCreditoService cartaoCreditoService;

}
