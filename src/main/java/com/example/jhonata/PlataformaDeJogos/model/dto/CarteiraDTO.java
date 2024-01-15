package com.example.jhonata.PlataformaDeJogos.model.dto;

import com.example.jhonata.PlataformaDeJogos.model.CartaoCredito;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CarteiraDTO {
    private Long id;
    private Float fundos;
    private List<CartaoCreditoDTO> cartaoCreditos;
}
