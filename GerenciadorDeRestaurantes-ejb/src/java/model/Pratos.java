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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author viniciusdias
 */
@Entity
@Table(name = "PRATOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pratos.findAll", query = "SELECT p FROM Pratos p")
    , @NamedQuery(name = "Pratos.findByNrop", query = "SELECT p FROM Pratos p WHERE p.nrop = :nrop")
    , @NamedQuery(name = "Pratos.findByTipos", query = "SELECT p FROM Pratos p WHERE p.tipos = :tipos")
    , @NamedQuery(name = "Pratos.findByValor", query = "SELECT p FROM Pratos p WHERE p.valor = :valor")})
public class Pratos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NROP")
    private Integer nrop;
    @Size(max = 20)
    @Column(name = "TIPOS")
    private String tipos;
    @Column(name = "VALOR")
    private Long valor;
    @OneToMany(mappedBy = "nrop")
    private Collection<Conta> contaCollection;
    @JoinColumn(name = "NROI", referencedColumnName = "NROI")
    @ManyToOne
    private Ingredientes nroi;

    public Pratos() {
    }

    public Pratos(Integer nrop) {
        this.nrop = nrop;
    }

    public Integer getNrop() {
        return nrop;
    }

    public void setNrop(Integer nrop) {
        this.nrop = nrop;
    }

    public String getTipos() {
        return tipos;
    }

    public void setTipos(String tipos) {
        this.tipos = tipos;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    @XmlTransient
    public Collection<Conta> getContaCollection() {
        return contaCollection;
    }

    public void setContaCollection(Collection<Conta> contaCollection) {
        this.contaCollection = contaCollection;
    }

    public Ingredientes getNroi() {
        return nroi;
    }

    public void setNroi(Ingredientes nroi) {
        this.nroi = nroi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nrop != null ? nrop.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pratos)) {
            return false;
        }
        Pratos other = (Pratos) object;
        if ((this.nrop == null && other.nrop != null) || (this.nrop != null && !this.nrop.equals(other.nrop))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Pratos[ nrop=" + nrop + " ]";
    }
    
}
