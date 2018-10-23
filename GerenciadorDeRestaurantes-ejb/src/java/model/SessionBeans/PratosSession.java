/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.SessionBeans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Pratos;

/**
 *
 * @author viniciusdias
 */
@Stateless
@LocalBean
public class PratosSession {

    @PersistenceContext(unitName = "GerenciadorDeRestaurantes-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
    public List<Pratos> getPratos() {
        Query query = em.createNamedQuery("Pratos.findAll");
        return query.getResultList();
    }
	
	public Pratos getPratosByNumero(Integer nrop) {
        Query query = em.createNamedQuery("Pratos.findByNrop");
		query.setParameter("nrop", nrop);
        return (Pratos) query.getSingleResult();
	}
	
	public Pratos createPratos(
			Integer nrop,
			String tipo,
                        Long valor
                        ) {
		Pratos prato = new Pratos(nrop, tipo, valor);
		persist(prato);
		
		return prato;
	}
	
	public void updatePratos(Pratos prato) {
		em.merge(prato);
		em.flush();
	}

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
