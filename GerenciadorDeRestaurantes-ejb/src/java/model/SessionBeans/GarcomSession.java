/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.SessionBeans;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Garcom;
import model.Gerente;

/**
 *
 * @author viniciusdias
 */
@Stateless
@LocalBean
public class GarcomSession {

    @PersistenceContext(unitName = "GerenciadorDeRestaurantes-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

	public List<model.Garcom> getGarcom() {
        Query query = em.createNamedQuery("Garcom.findAll");
        return query.getResultList();
    }
    public Garcom login(String cpf, String senha) {
            List<model.Garcom> garcons = getGarcom();
            for(Garcom garcom : garcons) {
                    if(garcom.getCpf().equals(cpf) &&
                                    garcom.getSenha().equals(senha)) {
                            return garcom;
                    }
            }

            return null;
    }   
  	
	public model.Garcom findGarcomByCpf(String cpf) {
        Query query = em.createNamedQuery("Garcom.findByCpf");
		query.setParameter("cpf", cpf);
        try {
			return (model.Garcom) query.getSingleResult();
		} catch(NoResultException ex) {
			return null;
		}
	}
	
	public model.Garcom createGarcom(
			String cpf,
			String senha
	) {
		model.Garcom garcom = new model.Garcom(cpf, senha);
		em.persist(garcom);
		
		return findGarcomByCpf(cpf);
	}
	
	public model.Garcom updateGarcom(
			String cpf,
			String senha
	) {
		Garcom garcom = new Garcom(cpf, senha);
		em.merge(garcom);
		em.flush();
		
		return findGarcomByCpf(cpf);
	}

    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
