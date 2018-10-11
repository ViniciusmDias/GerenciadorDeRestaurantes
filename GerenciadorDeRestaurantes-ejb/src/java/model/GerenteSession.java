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
public class GerenteSession {

    @PersistenceContext(unitName = "GerenciadorDeRestaurantes-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public List<model.Gerente> getListaGerente() {
        Query query = em.createNamedQuery("Gerente.findAll");
        return query.getResultList();
    }

    public void cadastrarGarcon(Garcon garcon) {  // Cadastra o cliente 
        em.persist(garcon);
    }
    
    public void salvarGarcon(Garcon garcon) {
        em.merge(garcon);
        em.flush();
    }
    
    public void removerGarcon(Long cpf) {
        em.remove(em.find(Garcon.class, cpf));
    }
    
    public Garcon editarGarcon(Long cpf) {
        return em.find(Garcon.class, cpf);
    }
    public List<model.Garcon> getListaGarcon() {
        Query query = em.createNamedQuery("Garcon.findAll");
        return query.getResultList();
    }

    public void cadastrarPratos(Pratos pratos) {
        em.persist(pratos);
    }

    public void removerPratos(Integer nrop) {
        em.remove(em.find(Pratos.class, nrop));
    }
    
    public Pratos editarPratos(Integer nrop) {
        return em.find(Pratos.class, nrop);
    }
    public List<model.Pratos> getListaPratos() {
        Query query = em.createNamedQuery("Pratos.findAll");
        return query.getResultList();
    }
    public void cadastrarIngredientes(Ingredientes ingredientes) {
        em.persist(ingredientes);
    }

    public void removerIngredientes(Integer nroi) {
        em.remove(em.find(Ingredientes.class, nroi));
    }
    
    public Pratos editarIngredientes(Integer nroi) {
        return em.find(Pratos.class, nroi);
    }
    public List<model.Ingredientes> getListaIngredientes() {
        Query query = em.createNamedQuery("Ingredientes.findAll");
        return query.getResultList();
    }
        public void cadastrarVendas(Vendas vendas) {
        em.persist(vendas);
    }

    public void removerVendas(Integer nrov) {
        em.remove(em.find(Vendas.class, nrov));
    }
    
    public Vendas editarVendas(Integer nrov) {
        return em.find(Vendas.class, nrov);
    }
    public List<model.Vendas> getListaVendas() {
        Query query = em.createNamedQuery("Vendas.findAll");
        return query.getResultList();
    }

}
