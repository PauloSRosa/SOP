package com.sop.builder;

import com.sop.model.Pagamento;
import com.sop.dto.PagamentoDTO;
import java.util.ArrayList;
import java.util.List;
public class PagamentoBuilder {

    public Pagamento toEntity(PagamentoDTO pagamentoDTO) {
        Pagamento pagamento = new Pagamento();
        pagamento.setAnoPagamento(pagamentoDTO.getAnoPagamento());
        pagamento.setNumeroPagamento(pagamentoDTO.getNumeroPagamento());
        pagamento.setDataPagamento(pagamentoDTO.getDataPagamento());
        pagamento.setValorPagamento(pagamentoDTO.getValorPagamento());
        pagamento.setObservacao(pagamentoDTO.getObservacao());
        return pagamento;
    }

    public List<PagamentoDTO> toDTOList(List<Pagamento> pagamentos) {
        List<PagamentoDTO> pagamentosDTO = new ArrayList<>();
        for (Pagamento pagamento : pagamentos) {
            pagamentosDTO.add(toDTO(pagamento));
        }
        return pagamentosDTO;
    }

    public PagamentoDTO toDTO(Pagamento pagamento) {
        PagamentoDTO pagamentoDTO = new PagamentoDTO();
        pagamentoDTO.setAnoPagamento(pagamento.getAnoPagamento());
        pagamentoDTO.setNumeroPagamento(pagamento.getNumeroPagamento());
        pagamentoDTO.setDataPagamento(pagamento.getDataPagamento());
        pagamentoDTO.setValorPagamento(pagamento.getValorPagamento());
        pagamentoDTO.setObservacao(pagamento.getObservacao());
        return pagamentoDTO;
    }

    // Add other methods if needed for conversion between lists or custom logic.
}
