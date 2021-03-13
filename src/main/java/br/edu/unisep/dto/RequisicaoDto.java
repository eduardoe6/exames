package br.edu.unisep.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class RequisicaoDto {

    private String paciente;
    private String formaPagto;

    private LocalDate data;

}
