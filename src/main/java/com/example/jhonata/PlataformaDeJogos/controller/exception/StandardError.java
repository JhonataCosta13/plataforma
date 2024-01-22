package com.example.jhonata.PlataformaDeJogos.controller.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StandardError {

    private Integer status;
    private String msg;
    private Long timestamp;
}
