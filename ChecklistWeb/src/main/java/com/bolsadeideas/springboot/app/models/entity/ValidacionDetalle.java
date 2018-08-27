/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bolsadeideas.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "validacion_detalle", catalog = "qc_help_revision", schema = "")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "ValidacionDetalle.findAll", query = "SELECT v FROM ValidacionDetalle v")
//    , @NamedQuery(name = "ValidacionDetalle.findByIdvalidacionDetalle", query = "SELECT v FROM ValidacionDetalle v WHERE v.idvalidacionDetalle = :idvalidacionDetalle")
//    , @NamedQuery(name = "ValidacionDetalle.findByFechaModificacion", query = "SELECT v FROM ValidacionDetalle v WHERE v.fechaModificacion = :fechaModificacion")
//    , @NamedQuery(name = "ValidacionDetalle.findByFechaMoficacionDate", query = "SELECT v FROM ValidacionDetalle v WHERE v.fechaMoficacionDate = :fechaMoficacionDate")
//    , @NamedQuery(name = "ValidacionDetalle.findByUltimoCambio", query = "SELECT v FROM ValidacionDetalle v WHERE v.ultimoCambio = :ultimoCambio")})

public class ValidacionDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idvalidacion_detalle", nullable = false)
    private Integer idvalidacionDetalle;
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @Column(name = "fecha_moficacion_date")
    @Temporal(TemporalType.DATE)
    private Date fechaMoficacionDate;
    @Column(name = "ultimo_cambio")
    private Boolean ultimoCambio;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario idusuario;
    @JoinColumn(name = "idvalidacion", referencedColumnName = "idrevision_validacion", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Validacion idvalidacion;

    public ValidacionDetalle() {
    }

    public ValidacionDetalle(Integer idvalidacionDetalle) {
        this.idvalidacionDetalle = idvalidacionDetalle;
    }

    public Integer getIdvalidacionDetalle() {
        return idvalidacionDetalle;
    }

    public void setIdvalidacionDetalle(Integer idvalidacionDetalle) {
        this.idvalidacionDetalle = idvalidacionDetalle;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Date getFechaMoficacionDate() {
        return fechaMoficacionDate;
    }

    public void setFechaMoficacionDate(Date fechaMoficacionDate) {
        this.fechaMoficacionDate = fechaMoficacionDate;
    }

    public Boolean getUltimoCambio() {
        return ultimoCambio;
    }

    public void setUltimoCambio(Boolean ultimoCambio) {
        this.ultimoCambio = ultimoCambio;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    public Validacion getIdvalidacion() {
        return idvalidacion;
    }

    public void setIdvalidacion(Validacion idvalidacion) {
        this.idvalidacion = idvalidacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idvalidacionDetalle != null ? idvalidacionDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ValidacionDetalle)) {
            return false;
        }
        ValidacionDetalle other = (ValidacionDetalle) object;
        if ((this.idvalidacionDetalle == null && other.idvalidacionDetalle != null) || (this.idvalidacionDetalle != null && !this.idvalidacionDetalle.equals(other.idvalidacionDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ValidacionDetalle[ idvalidacionDetalle=" + idvalidacionDetalle + " ]";
    }
    
}
