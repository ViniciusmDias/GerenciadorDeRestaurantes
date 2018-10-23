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
import model.SessionBeans.BebidasSession;
/**
 *
 * @author viniciusdias
 */
@Named(value = "bebidaMBean")
@RequestScoped
public class BebidaMBean {

    @EJB
    private BebidasSession bebidaSession;
    private String nome;
    private Integer nrob;
    private Long valor;
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNrob() {
        return nrob;
    }

    public void setNrob(Integer nrob) {
        this.nrob = nrob;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }
    
    public List<Bebidas> getListaBebidas() {
        return bebidaSession.getListaBebidas();
    }
    
    public Bebidas findBebidasByNome(String nome) {
        return bebidaSession.findBebidasByNome(nome);
    }

    public Bebidas findBebidasById(Integer nrob) {
        return bebidaSession.findBebidasById(nrob);
    }

    public Bebidas createBebidas() {
        return bebidaSession.createBebida(this.nrob, this.nome, this.valor);
    }
    
    
    /**n
     * Creates a new instance of BebidaMBean
     */
    public BebidaMBean() {  
    }
    


}
