/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import model.Pratos;
import model.SessionBeans.PratosSession;

/**
 *
 * @author viniciusdias
 */
@Named(value = "pratoMBean")
@Dependent
public class PratoMBean {

    @EJB
    private PratosSession pratosSession;

    private Integer nrop;
    private Long valor;

    public Integer getNrop() {
        return nrop;
    }

    public void setNrop(Integer nrop) {
        this.nrop = nrop;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }
	


    /**
     * Creates a new instance of QuartoJSFManagedBean
     */

    public List<Pratos> getPratos() {
        return pratosSession.getPratos();
    }

    public Pratos getPratoByNumero(Integer nrop) {
        return pratosSession.getPratosByNumero(nrop);
    }

    public Pratos createPrato(
            Integer nrop,
            String tipo,
            Long valor
    ) 
    {
        return pratosSession.createPratos(
                nrop,
                tipo,
                valor
        );
    }

    public void updatePratos(Pratos prato) {
        pratosSession.updatePratos(prato);
    }
    
    /**
     * Creates a new instance of PratoMBean
     */
    public PratoMBean() {
    }
    
}
