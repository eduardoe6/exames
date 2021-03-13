package br.edu.unisep.bean;

import br.edu.unisep.dto.ExameDto;
import br.edu.unisep.dto.FormaPagtoDto;
import br.edu.unisep.dto.NovaRequisicaoDto;
import br.edu.unisep.dto.PacienteDto;
import br.edu.unisep.repository.ExameRepository;
import br.edu.unisep.repository.FormaPagtoRepository;
import br.edu.unisep.repository.PacienteRepository;
import br.edu.unisep.repository.RequisicaoRepository;
import com.rcpadilha.hibernate.exception.DaoException;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
@Getter @Setter
public class NovaRequisicaoBean {

    private List<PacienteDto> pacientes;
    private List<ExameDto> exames;
    private List<FormaPagtoDto> formasPagtos;

    private NovaRequisicaoDto requisicao;

    private RequisicaoRepository reqRepo = new RequisicaoRepository();

    private ExameRepository exameRepo = new ExameRepository();
    private FormaPagtoRepository formaPagtoRepo = new FormaPagtoRepository();
    private PacienteRepository pacienteRepo = new PacienteRepository();

    @PostConstruct
    public void iniciar() {
        this.exames = exameRepo.listar();
        this.pacientes = pacienteRepo.listar();
        this.formasPagtos = formaPagtoRepo.listar();

        this.requisicao = new   NovaRequisicaoDto();
    }

    public String salvar() {
        try {
            reqRepo.salvar(requisicao);
            return "index?faces-redirect=true";
        } catch(DaoException e) {
            return "novaRequisicao";
        }
    }
}
