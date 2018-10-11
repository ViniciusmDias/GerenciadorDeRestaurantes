/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author viniciusdias
 */
@Stateless
@LocalBean
public class GarconSession {

    @PersistenceContext(unitName = "GerenciadorDeRestaurantes-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public List<model.Pratos> getListaPratos() {
        Query query = em.createNamedQuery("Pratos.findAll");
        return query.getResultList();
    }
    public List<model.Bebidas> getListaBebidas() {
        Query query = em.createNamedQuery("Bebidas.findAll");
        return query.getResultList();
    }
    public List<model.Conta> getListaContas() {
        Query query = em.createNamedQuery("Contas.findAll");
        return query.getResultList();
    }
    
    public void cadastrarConta(Conta conta) {
        em.persist(conta);
    }

    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
