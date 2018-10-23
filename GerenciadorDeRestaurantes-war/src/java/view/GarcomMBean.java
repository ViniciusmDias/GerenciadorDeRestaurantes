/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import model.Garcom;
import model.Gerente;
import model.SessionBeans.GarcomSession;

/**
 *
 * @author viniciusdias
 */
@Stateless
@LocalBean
public class GarcomMBean {
	
    @EJB
    private GarcomSession garcomSession;
    private String cpf;
    private String senha;
    
    
    
    /**
     * Creates a new instance of UsuarioJSFManagedBean
     */
    public GarcomMBean() {
    }

    public List<Garcom> getGarcom() {
            return garcomSession.getGarcom();
    }

    public Garcom findUsuarioByCpf(String cpf) {
            return garcomSession.findGarcomByCpf(cpf);
    }

    public Garcom createGarcom(
                    String cpf,
                    String senha
    ) {
            return garcomSession.createGarcom(cpf, senha);
    }

    public Garcom updateGarcom(
                    String cpf,
                    String senha
    ) {
            return garcomSession.updateGarcom(cpf, senha);
    }
    public String login() {
            Garcom garcom = garcomSession.login(this.cpf, this.senha);
            if(garcom != null) {
                    return "garcomDashboard?faces-redirect=true";
            } else {

            }
            return "garcomDashboard?faces-redirect=true";
    }
 
    
}
