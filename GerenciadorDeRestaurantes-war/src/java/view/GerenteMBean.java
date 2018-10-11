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
import model.Garcon;
import model.GerenteSession;
import model.Ingredientes;
import model.Pratos;
import model.Vendas;

/**
 *
 * @author gustavo
 */
@Named(value = "gerenteManagedBean")
@RequestScoped
public class GerenteMBean {

    @EJB
    private GerenteSession gerenteSession;
    
    private Gerente gerente = new Gerente();  // Guarda os dados do formulário

    private Garcon garcon = new Garcon();   
    private Pratos pratos = new Pratos();   
    private Ingredientes ingredientes = new Ingredientes();   
    private Vendas vendas = new Vendas();
    
    
    
    /**
     * Creates a new instance of GerenteManagedBean
     */
    public GerenteMBean() {
    }
    
    public List<Gerente> getListaGerente() {
        return gerenteSession.getListaGerente();
    }
    
    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public String cadastrarGarcon() {          // Chama o método do bean de sessão
        gerenteSession.cadastrarGarcon(garcon);
        garcon = new Garcon();
        return "index";
    }
    public List<Garcon> getListaGarcon() {
        return gerenteSession.getListaGarcon();
    }
    
    public String salvarGarcon() {
        gerenteSession.salvarGarcon(this.garcon);
        return "index";
    }
    
    public String removerGarcon(Long cpf) {
        gerenteSession.removerGarcon(cpf);
        return "index";
    }
    
    public void editarGarcon(Long cpf) {
        gerenteSession.editarGarcon(cpf);
    }
    
    
    public String cadastrarPratos() {          // Chama o método do bean de sessão
        gerenteSession.cadastrarPratos(pratos);
        pratos = new Pratos();
        return "index";
    }
    
}
