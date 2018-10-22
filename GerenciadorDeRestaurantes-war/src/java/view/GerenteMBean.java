package view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import model.Gerente;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import model.SessionBeans.GerenteSession;

/**
 *
 * @author gustavo
 */
@Named(value = "gerenteManagedBean")
@RequestScoped
public class GerenteMBean {

    @EJB
    private GerenteSession gerenteSession;

    private Integer id;
    private String senha;

    /**
     * Creates a new instance of FuncionarioJSFManagedBean
     */
    public GerenteMBean() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }



    public String login() {
            Gerente gerente = gerenteSession.login(this.id, this.senha);
            if(gerente != null) {
                    return "gerenteDashboard?faces-redirect=true";
            } else {

            }
            return "index";
    }

    public List<Gerente> getGerentes() {
            return gerenteSession.getListaGerente();
    }

}
