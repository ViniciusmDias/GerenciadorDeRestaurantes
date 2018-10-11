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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author viniciusdias
 */
@Entity
@Table(name = "VENDAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendas.findAll", query = "SELECT v FROM Vendas v")
    , @NamedQuery(name = "Vendas.findByNrov", query = "SELECT v FROM Vendas v WHERE v.nrov = :nrov")
    , @NamedQuery(name = "Vendas.findByValor", query = "SELECT v FROM Vendas v WHERE v.valor = :valor")})
public class Vendas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NROV")
    private Integer nrov;
    @Column(name = "VALOR")
    private Long valor;
    @JoinColumn(name = "NROC", referencedColumnName = "NROC")
    @ManyToOne
    private Conta nroc;

    public Vendas() {
    }

    public Vendas(Integer nrov) {
        this.nrov = nrov;
    }

    public Integer getNrov() {
        return nrov;
    }

    public void setNrov(Integer nrov) {
        this.nrov = nrov;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    public Conta getNroc() {
        return nroc;
    }

    public void setNroc(Conta nroc) {
        this.nroc = nroc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nrov != null ? nrov.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendas)) {
            return false;
        }
        Vendas other = (Vendas) object;
        if ((this.nrov == null && other.nrov != null) || (this.nrov != null && !this.nrov.equals(other.nrov))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Vendas[ nrov=" + nrov + " ]";
    }
    
}
