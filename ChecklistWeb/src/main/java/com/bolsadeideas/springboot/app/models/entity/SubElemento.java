/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bolsadeideas.springboot.app.models.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "sub_elemento", catalog = "qc_help_revision", schema = "")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "SubElemento.findAll", query = "SELECT s FROM SubElemento s")
//    , @NamedQuery(name = "SubElemento.findByIdsubelemento", query = "SELECT s FROM SubElemento s WHERE s.idsubelemento = :idsubelemento")
//    , @NamedQuery(name = "SubElemento.findByNombre", query = "SELECT s FROM SubElemento s WHERE s.nombre = :nombre")
//    , @NamedQuery(name = "SubElemento.findByEstado", query = "SELECT s FROM SubElemento s WHERE s.estado = :estado")})
//


public class SubElemento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsubelemento", nullable = false)
    private Integer idsubelemento;
    @Size(max = 45)
    @Column(name = "nombre", length = 45)
    private String nombre;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "descripcion", length = 2147483647)
    private String descripcion;
    @Column(name = "estado")
    private Boolean estado;
    @JoinColumn(name = "idelemento", referencedColumnName = "idelemento", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Elemento idelemento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idsubelemento", fetch = FetchType.LAZY)
    private List<Validacion> validacionList;

    public SubElemento() {
    }

    public SubElemento(Integer idsubelemento) {
        this.idsubelemento = idsubelemento;
    }

    public Integer getIdsubelemento() {
        return idsubelemento;
    }

    public void setIdsubelemento(Integer idsubelemento) {
        this.idsubelemento = idsubelemento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Elemento getIdelemento() {
        return idelemento;
    }

    public void setIdelemento(Elemento idelemento) {
        this.idelemento = idelemento;
    }

    @XmlTransient
    public List<Validacion> getValidacionList() {
        return validacionList;
    }

    public void setValidacionList(List<Validacion> validacionList) {
        this.validacionList = validacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsubelemento != null ? idsubelemento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubElemento)) {
            return false;
        }
        SubElemento other = (SubElemento) object;
        if ((this.idsubelemento == null && other.idsubelemento != null) || (this.idsubelemento != null && !this.idsubelemento.equals(other.idsubelemento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.SubElemento[ idsubelemento=" + idsubelemento + " ]";
    }
    
}
