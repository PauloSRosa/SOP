package com.sop.service;

import com.sop.model.Empenho;
import com.sop.dto.EmpenhoDTO;
import com.sop.builder.EmpenhoBuilder;
import com.sop.repository.EmpenhoDAO;
import javax.persistence.EntityManager;
import java.util.List;

public class EmpenhoService {

    private EmpenhoDAO empenhoDAO;
    private EmpenhoBuilder empenhoBuilder;

    public EmpenhoService(EntityManager em) {
        this.empenhoDAO = new EmpenhoDAO(em);
        this.empenhoBuilder = new EmpenhoBuilder();
    }

    public void salvarEmpenho(EmpenhoDTO empenhoDTO) {
        Empenho empenho = empenhoBuilder.toEntity(empenhoDTO);
        empenhoDAO.salvar(empenho);
    }

    public EmpenhoDTO buscarEmpenhoPorId(Long id) {
        Empenho empenho = empenhoDAO.buscarPorId(id);
        return empenhoBuilder.toDTO(empenho);
    }

    public List<EmpenhoDTO> listarEmpenhos() {
        List<Empenho> empenhos = empenhoDAO.listarEmpenhos();
        return empenhoBuilder.toDTOList(empenhos);
    }

    public List<EmpenhoDTO> listarEmpenhosComPagamentos() {
        List<Empenho> empenhos = empenhoDAO.listarEmpenhosComPagamentos();
        return empenhoBuilder.toDTOList(empenhos);
    }

    public void atualizarEmpenho(EmpenhoDTO empenhoDTO) {
        Empenho empenho = empenhoBuilder.toEntity(empenhoDTO);
        empenhoDAO.atualizar(empenho);
    }

    public void deletarEmpenho(Long id) {
        Empenho empenho = empenhoDAO.buscarPorId(id);
        if (empenho != null) {
            empenhoDAO.deletar(empenho);
        } else {
            throw new IllegalArgumentException("Empenho com ID " + id + " não encontrado.");
        }
    }


}
