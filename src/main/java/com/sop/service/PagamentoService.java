package com.sop.service;

import com.sop.dto.PagamentoDTO; // Importe a classe PagamentoDTO corretamente
import com.sop.builder.PagamentoBuilder; // Importe a classe PagamentoBuilder corretamente
import com.sop.model.Pagamento;
import com.sop.repository.PagamentoDAO;
import javax.persistence.EntityManager;
import java.util.List;

public class PagamentoService {

    private final PagamentoDAO pagamentoDAO;
    private final PagamentoBuilder pagamentoBuilder;

    public PagamentoService(EntityManager em) {
        this.pagamentoDAO = new PagamentoDAO(em);
        this.pagamentoBuilder = new PagamentoBuilder();
    }

    public void salvarPagamento(PagamentoDTO pagamentoDTO) {
        Pagamento pagamento = pagamentoBuilder.toEntity(pagamentoDTO);
        pagamentoDAO.salvar(pagamento);
    }

    public PagamentoDTO buscarPagamentoPorId(Long id) {
        Pagamento pagamento = pagamentoDAO.buscarPorId(id);
        return pagamentoBuilder.toDTO(pagamento);
    }

    public List<PagamentoDTO> listarPagamentos() {
        List<Pagamento> pagamentos = pagamentoDAO.listar();
        return pagamentoBuilder.toDTOList(pagamentos);
    }
}