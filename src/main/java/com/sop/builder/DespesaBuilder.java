package com.sop.builder;

import com.sop.model.Despesa;
import com.sop.dto.DespesaDTO;
import java.util.ArrayList;
import java.util.List;

public class DespesaBuilder {

    public DespesaDTO toDTO(Despesa despesa) {
        DespesaDTO despesaDTO = new DespesaDTO();

        despesaDTO.setNumeroProtocolo(despesa.getNumeroProtocolo());
        despesaDTO.setTipoDespesa(despesa.getTipoDespesa());
        despesaDTO.setDataProtocolo(despesa.getDataProtocolo());
        despesaDTO.setDataVencimento(despesa.getDataVencimento());
        despesaDTO.setCredor(despesa.getCredor());
        despesaDTO.setDescricao(despesa.getDescricao());
        despesaDTO.setValorDespesa(despesa.getValorDespesa());
        despesaDTO.setStatus(despesa.getStatus());
        return despesaDTO;
    }

    public List<DespesaDTO> toDTOList(List<Despesa> despesas) {
        List<DespesaDTO> despesaDTOs = new ArrayList<>();
        for (Despesa despesa : despesas) {
            despesaDTOs.add(toDTO(despesa));
        }
        return despesaDTOs;
    }

    public static Despesa toEntity(DespesaDTO despesaDTO) {
        Despesa despesa = new Despesa();

        despesa.setNumeroProtocolo(despesaDTO.getNumeroProtocolo());
        despesa.setTipoDespesa(despesaDTO.getTipoDespesa());
        despesa.setDataProtocolo(despesaDTO.getDataProtocolo());
        despesa.setDataVencimento(despesaDTO.getDataVencimento());
        despesa.setCredor(despesaDTO.getCredor());
        despesa.setDescricao(despesaDTO.getDescricao());
        despesa.setValorDespesa(despesaDTO.getValorDespesa());
        despesa.setStatus(despesaDTO.getStatus());
        return despesa;
    }
}
