package br.edu.unisep.bean;

import br.edu.unisep.dto.RequisicaoDto;
import br.edu.unisep.entity.Requisicao;
import br.edu.unisep.repository.RequisicaoRepository;
import com.rcpadilha.hibernate.dao.HibernateDao;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class ListaRequisicoesBean {

    @Getter @Setter
    private List<RequisicaoDto> requisicoes;

    @PostConstruct
    public void iniciar() {
        var repo = new RequisicaoRepository();
        this.requisicoes = repo.listar();
    }
}
