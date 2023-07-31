package com.sop.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.sop.model.Empenho;

public class EmpenhoDAO {

    private final EntityManager em;

    public EmpenhoDAO(EntityManager em) {
        this.em = em;
    }

    public void salvar(Empenho empenho) {
        em.getTransaction().begin();
        em.persist(empenho);
        em.getTransaction().commit();
    }

    public Empenho buscarPorId(Long id) {
        return em.find(Empenho.class, id);
    }

    public void atualizar(Empenho empenho) {
        em.getTransaction().begin();
        em.merge(empenho);
        em.getTransaction().commit();
    }

    public void deletar(Empenho empenho) {
        em.getTransaction().begin();
        em.remove(empenho);
        em.getTransaction().commit();
    }

    public List<Empenho> listarEmpenhos() {
        String jpql = "SELECT e FROM Empenho e";
        TypedQuery<Empenho> query = em.createQuery(jpql, Empenho.class);
        return query.getResultList();
    }

    // Métodos de consulta específicos para controle de situação

    public List<Empenho> listarEmpenhosComPagamentos() {
        String jpql = "SELECT e FROM Empenho e WHERE NOT e.pagamentos IS EMPTY";
        TypedQuery<Empenho> query = em.createQuery(jpql, Empenho.class);
        return query.getResultList();
    }

    // Outros métodos de consulta específicos conforme os requisitos.
}
