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
@Table(name = "INGREDIENTES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ingredientes.findAll", query = "SELECT i FROM Ingredientes i")
    , @NamedQuery(name = "Ingredientes.findByNroi", query = "SELECT i FROM Ingredientes i WHERE i.nroi = :nroi")
    , @NamedQuery(name = "Ingredientes.findByNome", query = "SELECT i FROM Ingredientes i WHERE i.nome = :nome")
    , @NamedQuery(name = "Ingredientes.findByValor", query = "SELECT i FROM Ingredientes i WHERE i.valor = :valor")
    , @NamedQuery(name = "Ingredientes.findByPeso", query = "SELECT i FROM Ingredientes i WHERE i.peso = :peso")})
public class Ingredientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NROI")
    private Integer nroi;
    @Size(max = 40)
    @Column(name = "NOME")
    private String nome;
    @Column(name = "VALOR")
    private Long valor;
    @Column(name = "PESO")
    private Long peso;
    @OneToMany(mappedBy = "nroi")
    private Collection<Pratos> pratosCollection;

    public Ingredientes() {
    }

    public Ingredientes(Integer nroi) {
        this.nroi = nroi;
    }

    public Integer getNroi() {
        return nroi;
    }

    public void setNroi(Integer nroi) {
        this.nroi = nroi;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    public Long getPeso() {
        return peso;
    }

    public void setPeso(Long peso) {
        this.peso = peso;
    }

    @XmlTransient
    public Collection<Pratos> getPratosCollection() {
        return pratosCollection;
    }

    public void setPratosCollection(Collection<Pratos> pratosCollection) {
        this.pratosCollection = pratosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nroi != null ? nroi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingredientes)) {
            return false;
        }
        Ingredientes other = (Ingredientes) object;
        if ((this.nroi == null && other.nroi != null) || (this.nroi != null && !this.nroi.equals(other.nroi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Ingredientes[ nroi=" + nroi + " ]";
    }
    
}
