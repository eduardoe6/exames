package br.edu.unisep.repository;

import br.edu.unisep.dto.ExameDto;
import br.edu.unisep.entity.Exame;
import com.rcpadilha.hibernate.dao.HibernateDao;

import java.util.List;
import java.util.stream.Collectors;

public class ExameRepository {

    public List<ExameDto> listar() {
        var dao = new HibernateDao<Exame>();
        var exames = dao.find(Exame.class);

        return exames.stream().map( e ->
            new ExameDto(e.getId(), e.getDescricao(), e.getValor())
        ).collect(Collectors.toList());
    }

}
