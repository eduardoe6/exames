package br.edu.unisep.repository;

import br.edu.unisep.dto.FormaPagtoDto;
import br.edu.unisep.entity.FormaPagto;
import com.rcpadilha.hibernate.dao.HibernateDao;

import java.util.List;
import java.util.stream.Collectors;

public class FormaPagtoRepository {

    public List<FormaPagtoDto> listar() {
        var dao = new HibernateDao<FormaPagto>();
        var formasPagto = dao.find(FormaPagto.class);

        return formasPagto.stream().map(
                fp -> new FormaPagtoDto(fp.getId(), fp.getDescricao())
        ).collect(Collectors.toList());
    }

}
