package com.sop.service;

import com.sop.model.Empenho;
import com.sop.model.Pagamento;
import com.sop.model.Despesa;
import com.sop.dto.DespesaDTO;
import com.sop.builder.DespesaBuilder;
import com.sop.repository.DespesaDAO;
import javax.persistence.EntityManager;
import java.util.List;

public class DespesaService {

    private final DespesaDAO despesaDAO;
    private final DespesaBuilder despesaBuilder;

    public DespesaService(EntityManager em) {
        this.despesaDAO = new DespesaDAO(em);
        this.despesaBuilder = new DespesaBuilder();
    }

    public void salvarDespesa(DespesaDTO despesaDTO) {
        Despesa despesa = despesaBuilder.toEntity(despesaDTO);
        despesaDAO.salvar(despesa);
    }

    public DespesaDTO buscarDespesaPorId(Long id) {
        Despesa despesa = despesaDAO.buscarPorId(id);
        return despesaBuilder.toDTO(despesa);
    }

    public List<DespesaDTO> listarDespesas() {
        List<Despesa> despesas = despesaDAO.listar();
        return despesaBuilder.toDTOList(despesas);
    }

    public double calcularValorTotalEmpenhado(Despesa despesa) {
        double valorTotalEmpenhado = 0.0;
        for (Empenho empenho : despesa.getEmpenhos()) {
            valorTotalEmpenhado += empenho.getValorEmpenho();
        }
        return valorTotalEmpenhado;
    }

    public double calcularValorTotalPago(Despesa despesa) {
        double valorTotalPago = 0.0;
        for (Pagamento pagamento : despesa.getPagamentos()) {
            valorTotalPago += pagamento.getValorPagamento();
        }
        return valorTotalPago;
    }

    public void atualizarStatusDespesa(Despesa despesa) {
        double valorTotalEmpenhado = calcularValorTotalEmpenhado(despesa);
        double valorTotalPago = calcularValorTotalPago(despesa);
        double valorTotalDespesa = despesa.getValorDespesa();

        if (valorTotalPago == valorTotalDespesa) {
            despesa.setStatus("paga");
        } else if (valorTotalPago > 0 && valorTotalPago < valorTotalDespesa) {
            despesa.setStatus("parcialmente paga");
        } else if (valorTotalEmpenhado == valorTotalDespesa) {
            despesa.setStatus("aguardando pagamento");
        } else if (valorTotalEmpenhado > 0 && valorTotalEmpenhado < valorTotalDespesa) {
            despesa.setStatus("parcialmente empenhada");
        } else {
            despesa.setStatus("aguardando empenho");
        }
    }

}
