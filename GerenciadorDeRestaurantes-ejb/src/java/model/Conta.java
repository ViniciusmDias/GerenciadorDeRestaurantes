/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author viniciusdias
 */
@Entity
@Table(name = "CONTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conta.findAll", query = "SELECT c FROM Conta c")
    , @NamedQuery(name = "Conta.findByNroc", query = "SELECT c FROM Conta c WHERE c.nroc = :nroc")
    , @NamedQuery(name = "Conta.findByValor", query = "SELECT c FROM Conta c WHERE c.valor = :valor")})
public class Conta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NROC")
    private Integer nroc;
    @Column(name = "VALOR")
    private Long valor;
    @OneToMany(mappedBy = "nroc")
    private Collection<Vendas> vendasCollection;
    @JoinColumn(name = "NROB", referencedColumnName = "NROB")
    @ManyToOne
    private Bebidas nrob;
    @JoinColumn(name = "NROP", referencedColumnName = "NROP")
    @ManyToOne
    private Pratos nrop;

    public Conta() {
    }

    public Conta(Integer nroc) {
        this.nroc = nroc;
    }

    public Integer getNroc() {
        return nroc;
    }

    public void setNroc(Integer nroc) {
        this.nroc = nroc;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    @XmlTransient
    public Collection<Vendas> getVendasCollection() {
        return vendasCollection;
    }

    public void setVendasCollection(Collection<Vendas> vendasCollection) {
        this.vendasCollection = vendasCollection;
    }

    public Bebidas getNrob() {
        return nrob;
    }

    public void setNrob(Bebidas nrob) {
        this.nrob = nrob;
    }

    public Pratos getNrop() {
        return nrop;
    }

    public void setNrop(Pratos nrop) {
        this.nrop = nrop;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nroc != null ? nroc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conta)) {
            return false;
        }
        Conta other = (Conta) object;
        if ((this.nroc == null && other.nroc != null) || (this.nroc != null && !this.nroc.equals(other.nroc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Conta[ nroc=" + nroc + " ]";
    }
    
}
