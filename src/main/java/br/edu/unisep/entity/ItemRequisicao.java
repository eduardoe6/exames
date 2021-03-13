package br.edu.unisep.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name="item_requisicao")
public class ItemRequisicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_item")
    private Integer id;

    @Column(name="vl_exame")
    private Double valor;

    @ManyToOne
    @JoinColumn(name="id_exame")
    private Exame exame;

    @ManyToOne
    @JoinColumn(name="id_requisicao")
    private Requisicao requisicao;
    
}
