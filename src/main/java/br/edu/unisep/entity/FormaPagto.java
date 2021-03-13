package br.edu.unisep.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="forma_pagto")
public class FormaPagto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_formapagto")
    private Integer id;

    @Column(name="ds_formapagto")
    private String descricao;

    public FormaPagto(Integer id) {
        this.id = id;
    }

}
