package br.edu.unisep.repository;

import br.edu.unisep.dto.NovaRequisicaoDto;
import br.edu.unisep.dto.RequisicaoDto;
import br.edu.unisep.entity.*;
import com.rcpadilha.hibernate.dao.HibernateDao;
import com.rcpadilha.hibernate.exception.DaoException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RequisicaoRepository {

    public void salvar(NovaRequisicaoDto req) throws DaoException{

        var requisicao = new Requisicao();

        requisicao.setPaciente(new Paciente( req.getPaciente() ));
        requisicao.setFormaPagto(new FormaPagto( req.getFormaPagto() ));
        
        requisicao.setData(LocalDate.now());

        var exDao = new HibernateDao<Exame>();
        var itens = new ArrayList<ItemRequisicao>();

        for (var e : req.getExamesReq()) {
            var item = new ItemRequisicao();

            // Consulta no banco os dados do exame selecionado
            var ex = exDao.findById(Exame.class, e);

            item.setExame(ex);
            item.setValor(ex.getValor());
            item.setRequisicao(requisicao);

            // Adiciona o item criado à lista de itens da requisição
            itens.add(item);
        }

        requisicao.setItens(itens);

        var reqDao = new HibernateDao<Requisicao>();
        reqDao.save(requisicao);
    }


    public List<RequisicaoDto> listar() {
        var dao = new HibernateDao<Requisicao>();
        var reqs = dao.find(Requisicao.class);

        return reqs.stream().map(
                r -> new RequisicaoDto(r.getPaciente().getNome(),
                        r.getFormaPagto().getDescricao(),
                        r.getData())
        ).collect(Collectors.toList());

    }

}
