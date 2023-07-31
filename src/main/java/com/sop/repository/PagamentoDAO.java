package com.sop.repository;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.sop.model.Pagamento;

public class PagamentoDAO {

    private EntityManager em;

    public PagamentoDAO(EntityManager em) {
        this.em = em;
    }

    public void salvar(Pagamento pagamento) {
        em.persist(pagamento);
    }

    public Pagamento buscarPorId(Long id) {
        return em.find(Pagamento.class, id);
    }

    public void atualizar(Pagamento pagamento) {
        em.merge(pagamento);
    }

    public void deletar(Pagamento pagamento) {
        em.remove(pagamento);
    }

    public List<Pagamento> listar() {
        TypedQuery<Pagamento> query = em.createQuery("SELECT p FROM Pagamento p", Pagamento.class);
        return query.getResultList();
    }

    public List<Pagamento> listarPagamentosPorPeriodo(Date dataInicio, Date dataFim) {
        String jpql = "SELECT p FROM Pagamento p WHERE p.dataPagamento BETWEEN :dataInicio AND :dataFim";
        TypedQuery<Pagamento> query = em.createQuery(jpql, Pagamento.class);
        query.setParameter("dataInicio", dataInicio);
        query.setParameter("dataFim", dataFim);
        return query.getResultList();
    }

}
