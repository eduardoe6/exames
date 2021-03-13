package br.edu.unisep.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_paciente")
    private Integer id;

    @Column(name="ds_paciente")
    private String nome;

    @Column(name="ds_email")
    private String email;

    public Paciente(Integer id) {
        this.id = id;
    }

}
