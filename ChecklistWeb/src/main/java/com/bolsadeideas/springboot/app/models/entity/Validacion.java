/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bolsadeideas.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
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
@Table(name = "validacion", catalog = "qc_help_revision", schema = "")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Validacion.findAll", query = "SELECT v FROM Validacion v")
//    , @NamedQuery(name = "Validacion.findByIdrevisionValidacion000", query = "SELECT v FROM Validacion v WHERE v.idrevisionValidacion = :idrevisionValidacion")
//    , @NamedQuery(name = "Validacion.findByRevision", query = "SELECT v FROM Validacion v WHERE v.revision = :revision")
//    , @NamedQuery(name = "Validacion.findByFechaCreacion", query = "SELECT v FROM Validacion v WHERE v.fechaCreacion = :fechaCreacion")
//    , @NamedQuery(name = "Validacion.findByFechaDesactivacion", query = "SELECT v FROM Validacion v WHERE v.fechaDesactivacion = :fechaDesactivacion")
//    , @NamedQuery(name = "Validacion.findByEstado", query = "SELECT v FROM Validacion v WHERE v.estado = :estado")
//    , @NamedQuery(name = "Validacion.findByTitulo", query = "SELECT v FROM Validacion v WHERE v.titulo = :titulo")})


public class Validacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrevision_validacion", nullable = false)
    private Integer idrevisionValidacion;
    @Size(max = 250)
    @Column(name = "revision", length = 250)
    private String revision;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "detalle", length = 2147483647)
    private String detalle;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "ayuda", length = 2147483647)
    private String ayuda;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "fecha_desactivacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDesactivacion;
    @Column(name = "estado")
    private Boolean estado;
    @Size(max = 250)
    @Column(name = "titulo", length = 250)
    private String titulo;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "descripcion", length = 2147483647)
    private String descripcion;
    @JoinColumn(name = "idsubelemento", referencedColumnName = "idsubelemento", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private SubElemento idsubelemento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idvalidacion", fetch = FetchType.LAZY)
    private List<ValidacionDetalle> validacionDetalleList;

    
    public Validacion(Integer idrevisionValidacion, String revision, String detalle, String ayuda) {
    	this.idrevisionValidacion= idrevisionValidacion;
    	this.revision= revision;
    	this.detalle = detalle;
    	this.ayuda = ayuda;
    	
    }
    
    
    
    public Validacion() {
    	this.validacionDetalleList = new LinkedList<>();
    }

    public Validacion(Integer idrevisionValidacion) {
        this.idrevisionValidacion = idrevisionValidacion;
    }

    public Integer getIdrevisionValidacion() {
        return idrevisionValidacion;
    }

    public void setIdrevisionValidacion(Integer idrevisionValidacion) {
        this.idrevisionValidacion = idrevisionValidacion;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getAyuda() {
        return ayuda;
    }

    public void setAyuda(String ayuda) {
        this.ayuda = ayuda;
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

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public SubElemento getIdsubelemento() {
        return idsubelemento;
    }

    public void setIdsubelemento(SubElemento idsubelemento) {
        this.idsubelemento = idsubelemento;
    }

    @XmlTransient
    public List<ValidacionDetalle> getValidacionDetalleList() {
        return validacionDetalleList;
    }

    public void setValidacionDetalleList(List<ValidacionDetalle> validacionDetalleList) {
        this.validacionDetalleList = validacionDetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrevisionValidacion != null ? idrevisionValidacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Validacion)) {
            return false;
        }
        Validacion other = (Validacion) object;
        if ((this.idrevisionValidacion == null && other.idrevisionValidacion != null) || (this.idrevisionValidacion != null && !this.idrevisionValidacion.equals(other.idrevisionValidacion))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "Validacion [idrevisionValidacion=" + idrevisionValidacion + ", revision=" + revision + ", detalle="
				+ detalle + ", ayuda=" + ayuda + ", fechaDesactivacion=" + fechaDesactivacion + "]";
	}

    
    
}
