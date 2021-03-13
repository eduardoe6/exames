package br.edu.unisep.repository;

import br.edu.unisep.dto.PacienteDto;
import br.edu.unisep.entity.Paciente;
import com.rcpadilha.hibernate.dao.HibernateDao;

import java.util.List;
import java.util.stream.Collectors;

public class PacienteRepository {

    public List<PacienteDto> listar() {
        var dao = new HibernateDao<Paciente>();
        var pacientes = dao.find(Paciente.class);

        return pacientes.stream().map(
            p -> new PacienteDto(p.getId(), p.getNome())
        ).collect(Collectors.toList());
    }
}