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
import model.Bebidas;

/**
 *
 * @author viniciusdias
 */
@Stateless
@LocalBean
public class BebidasSession {

    @PersistenceContext(unitName = "GerenciadorDeRestaurantes-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    // Metodo que retorna a lista de clientes armazenada na tabela Clientes
    public List<model.Bebidas> getListaBebidas() {
        Query query = em.createNamedQuery("Bebidas.findAll");
        return query.getResultList();
    }

    public Bebidas findBebidasByNome(String nome) {
            for(Bebidas bebida : getListaBebidas()) {
                    if(bebida.getNome().equals(nome)) return bebida;
            }

            return null;
    }

    public Bebidas findBebidasById(Integer nrob) {
            for(Bebidas bebida : getListaBebidas()) {
                    if(bebida.getNrob().equals(nrob)) return bebida;
            }

            return null;
    }

    public Bebidas createBebida(Integer nrob, String nome, Long valor) {
            Bebidas bebida = new Bebidas(nrob, nome, valor);
            persist(bebida);

            return findBebidasByNome(nome);
    }    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
