/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bolsadeideas.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "elemento", catalog = "qc_help_revision", schema = "")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Elemento.findAll", query = "SELECT e FROM Elemento e")
//    , @NamedQuery(name = "Elemento.findByIdelemento", query = "SELECT e FROM Elemento e WHERE e.idelemento = :idelemento")
//    , @NamedQuery(name = "Elemento.findByNombre", query = "SELECT e FROM Elemento e WHERE e.nombre = :nombre")
//    , @NamedQuery(name = "Elemento.findByEstado", query = "SELECT e FROM Elemento e WHERE e.estado = :estado")
//    , @NamedQuery(name = "Elemento.findByFechaCreacion", query = "SELECT e FROM Elemento e WHERE e.fechaCreacion = :fechaCreacion")
//    , @NamedQuery(name = "Elemento.findByFechaDesactivacion", query = "SELECT e FROM Elemento e WHERE e.fechaDesactivacion = :fechaDesactivacion")})
public class Elemento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idelemento", nullable = false)
    private Integer idelemento;
    @Size(max = 45)
    @Column(name = "nombre", length = 45)
    private String nombre;
    @Column(name = "estado")
    private Boolean estado;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "descripcion", length = 2147483647)
    private String descripcion;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "fecha_desactivacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDesactivacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idelemento", fetch = FetchType.LAZY)
    private List<SubElemento> subElementoList;

    public Elemento() {
    }

    public Elemento(Integer idelemento) {
        this.idelemento = idelemento;
    }

    public Integer getIdelemento() {
        return idelemento;
    }

    public void setIdelemento(Integer idelemento) {
        this.idelemento = idelemento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaDesactivacion() {
        return fechaDesactivacion;
    }

    public void setFechaDesactivacion(Date fechaDesactivacion) {
        this.fechaDesactivacion = fechaDesactivacion;
    }

    @XmlTransient
    public List<SubElemento> getSubElementoList() {
        return subElementoList;
    }

    public void setSubElementoList(List<SubElemento> subElementoList) {
        this.subElementoList = subElementoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idelemento != null ? idelemento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Elemento)) {
            return false;
        }
        Elemento other = (Elemento) object;
        if ((this.idelemento == null && other.idelemento != null) || (this.idelemento != null && !this.idelemento.equals(other.idelemento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.Elemento[ idelemento=" + idelemento + " ]";
    }
    
}
