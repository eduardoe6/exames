package br.edu.unisep.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name="requisicao")
public class Requisicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_requisicao")
    private Integer id;

    @Column(name="dt_exame")
    private LocalDate data;

    @OneToOne
    @JoinColumn(name="id_paciente")
    private Paciente paciente;

    @OneToOne
    @JoinColumn(name="id_formapagto")
    private FormaPagto formaPagto;

    @OneToMany(mappedBy = "requisicao", cascade = CascadeType.ALL)
    private List<ItemRequisicao> itens;

}
