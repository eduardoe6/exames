package br.edu.unisep.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="exame")
public class Exame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_exame")
    private Integer id;

    @Column(name="ds_exame")
    private String descricao;

    @Column(name="vl_exame")
    private Double valor;

}
