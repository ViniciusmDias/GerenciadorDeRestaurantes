/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author viniciusdias
 */
@Entity
@Table(name = "GARCOM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Garcom.findAll", query = "SELECT g FROM Garcom g")
    , @NamedQuery(name = "Garcom.findByCpf", query = "SELECT g FROM Garcom g WHERE g.cpf = :cpf")
    , @NamedQuery(name = "Garcom.findBySenha", query = "SELECT g FROM Garcom g WHERE g.senha = :senha")})
public class Garcom implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "CPF")
    private String cpf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "SENHA")
    private String senha;

    public Garcom() {
    }

    public Garcom(String cpf) {
        this.cpf = cpf;
    }

    public Garcom(String cpf, String senha) {
        this.cpf = cpf;
        this.senha = senha;
    }

    public Garcom(String nome, String cpf, String endereco, String telefone) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cpf != null ? cpf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Garcom)) {
            return false;
        }
        Garcom other = (Garcom) object;
        if ((this.cpf == null && other.cpf != null) || (this.cpf != null && !this.cpf.equals(other.cpf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Garcom[ cpf=" + cpf + " ]";
    }
    
}
