package br.edu.unisep.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExameDto {

    private Integer id;

    private String descricao;

    private Double valor;

}
