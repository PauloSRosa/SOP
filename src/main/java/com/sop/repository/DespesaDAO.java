package com.sop.repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.sop.model.Despesa;
import java.util.List;

public class DespesaDAO {

    private final EntityManager em;

    public DespesaDAO(EntityManager em) {
        this.em = em;
    }

    public void salvar(Despesa despesa) {
        em.getTransaction().begin();
        em.persist(despesa);
        em.getTransaction().commit();
    }

    public Despesa buscarPorId(Long id) {
        return em.find(Despesa.class, id);
    }

    public void atualizar(Despesa despesa) {
        em.getTransaction().begin();
        em.merge(despesa);
        em.getTransaction().commit();
    }

    public void deletar(Despesa despesa) {
        em.getTransaction().begin();
        em.remove(despesa);
        em.getTransaction().commit();
    }

    public List<Despesa> listar() {
        String jpql = "SELECT d FROM Despesa d";
        TypedQuery<Despesa> query = em.createQuery(jpql, Despesa.class);
        return query.getResultList();
    }

    // Métodos de consulta específicos para controle de situação

    public List<Despesa> listarDespesasAguardandoEmpenho() {
        String jpql = "SELECT d FROM Despesa d WHERE d.empenhos IS EMPTY";
        TypedQuery<Despesa> query = em.createQuery(jpql, Despesa.class);
        return query.getResultList();
    }

    public List<Despesa> listarDespesasParcialmenteEmpenhadas() {
        String jpql = "SELECT d FROM Despesa d WHERE SIZE(d.empenhos) > 0 AND d.valorTotalEmpenhado < d.valorTotal";
        TypedQuery<Despesa> query = em.createQuery(jpql, Despesa.class);
        return query.getResultList();
    }

    public List<Despesa> listarDespesasAguardandoPagamento() {
        String jpql = "SELECT d FROM Despesa d WHERE d.valorTotalEmpenhado = d.valorTotal AND d.pagamentos IS EMPTY";
        TypedQuery<Despesa> query = em.createQuery(jpql, Despesa.class);
        return query.getResultList();
    }

    public List<Despesa> listarDespesasParcialmentePagas() {
        String jpql = "SELECT d FROM Despesa d WHERE SIZE(d.pagamentos) > 0 AND d.valorTotalPago < d.valorTotal";
        TypedQuery<Despesa> query = em.createQuery(jpql, Despesa.class);
        return query.getResultList();
    }

    public List<Despesa> listarDespesasPagas() {
        String jpql = "SELECT d FROM Despesa d WHERE d.valorTotalPago = d.valorTotal";
        TypedQuery<Despesa> query = em.createQuery(jpql, Despesa.class);
        return query.getResultList();
    }

    // Outros métodos de consulta específicos conforme os requisitos.
}
