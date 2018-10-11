/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import model.Bebidas;
import model.BebidasSession;
/**
 *
 * @author viniciusdias
 */
@Named(value = "bebidaMBean")
@RequestScoped
public class BebidaMBean {

    @EJB
    private BebidasSession bebidaSession;
    
    public List<Bebidas> getListaBebidas() {
        return bebidaSession.getListaBebidas();
    }
    /**n
     * Creates a new instance of BebidaMBean
     */
    public BebidaMBean() {  
    }
    


}
