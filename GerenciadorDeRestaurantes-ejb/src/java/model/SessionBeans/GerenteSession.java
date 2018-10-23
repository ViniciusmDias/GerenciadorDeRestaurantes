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
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Gerente;

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
    public Gerente login(Integer id, String senha) {
            List<model.Gerente> gerentes = getListaGerente();
            for(Gerente gerente : gerentes) {
                    if(gerente.getId().equals(id) &&
                                    gerente.getSenha().equals(senha)) {
                            return gerente;
                    }
            }

            return null;
    }   
    
    public List<model.Gerente> getListaGerente() {
        Query query = em.createNamedQuery("Gerente.findAll");
        return query.getResultList();
    }
}
