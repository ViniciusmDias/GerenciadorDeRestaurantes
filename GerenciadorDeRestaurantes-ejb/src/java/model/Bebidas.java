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
@Table(name = "BEBIDAS")
@XmlRootElement
@NamedQueries({
      @NamedQuery(name = "Bebidas.findAll", query = "SELECT b FROM Bebidas b")
    , @NamedQuery(name = "Bebidas.findByNrob", query = "SELECT b FROM Bebidas b WHERE b.nrob = :nrob")
    , @NamedQuery(name = "Bebidas.findByNome", query = "SELECT b FROM Bebidas b WHERE b.nome = :nome")
    , @NamedQuery(name = "Bebidas.findByValor", query = "SELECT b FROM Bebidas b WHERE b.valor = :valor")})
public class Bebidas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NROB")
    private Integer nrob;
    @Size(max = 40)
    @Column(name = "NOME")
    private String nome;
    @Column(name = "VALOR")
    private Long valor;
    @OneToMany(mappedBy = "nrob")
    private Collection<Conta> contaCollection;

    public Bebidas() {
    }

    public Bebidas(Integer nrob) {
        this.nrob = nrob;
    }

    public Bebidas(Integer nrob, String nome, Long valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getNrob() {
        return nrob;
    }

    public void setNrob(Integer nrob) {
        this.nrob = nrob;
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

    @XmlTransient
    public Collection<Conta> getContaCollection() {
        return contaCollection;
    }

    public void setContaCollection(Collection<Conta> contaCollection) {
        this.contaCollection = contaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nrob != null ? nrob.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bebidas)) {
            return false;
        }
        Bebidas other = (Bebidas) object;
        if ((this.nrob == null && other.nrob != null) || (this.nrob != null && !this.nrob.equals(other.nrob))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Bebidas[ nrob=" + nrob + " ]";
    }
    
}
