package com.sop.builder;

import com.sop.model.Empenho;
import com.sop.dto.EmpenhoDTO;
import java.util.List;
import java.util.ArrayList;
public class EmpenhoBuilder {

    public Empenho toEntity(EmpenhoDTO empenhoDTO) {
        Empenho empenho = new Empenho();
        empenho.setAnoEmpenho(empenhoDTO.getAnoEmpenho());
        empenho.setNumeroEmpenho(empenhoDTO.getNumeroEmpenho());
        empenho.setDataEmpenho(empenhoDTO.getDataEmpenho());
        empenho.setValorEmpenho(empenhoDTO.getValorEmpenho());
        empenho.setObservacao(empenhoDTO.getObservacao());
        empenho.setStatus(empenhoDTO.getStatus());
        return empenho;
    }

    public List<EmpenhoDTO> toDTOList(List<Empenho> empenhos) {
        List<EmpenhoDTO> empenhoDTOList = new ArrayList<>();
        for (Empenho empenho : empenhos) {
            empenhoDTOList.add(toDTO(empenho));
        }
        return empenhoDTOList;
    }

    public EmpenhoDTO toDTO(Empenho empenho) {
        EmpenhoDTO empenhoDTO = new EmpenhoDTO();
        empenhoDTO.setAnoEmpenho(empenho.getAnoEmpenho());
        empenhoDTO.setNumeroEmpenho(empenho.getNumeroEmpenho());
        empenhoDTO.setDataEmpenho(empenho.getDataEmpenho());
        empenhoDTO.setValorEmpenho(empenho.getValorEmpenho());
        empenhoDTO.setObservacao(empenho.getObservacao());
        empenhoDTO.setStatus(empenho.getStatus());
        return empenhoDTO;
    }


}
