package br.edu.unisep.dto;

import lombok.Data;

@Data
public class NovaRequisicaoDto {

    private Integer paciente;

    private Integer formaPagto;

    private Integer[] examesReq;

}
