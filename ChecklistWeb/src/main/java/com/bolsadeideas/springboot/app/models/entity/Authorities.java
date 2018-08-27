/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bolsadeideas.springboot.app.models.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "authorities", catalog = "qc_help_revision", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Authorities.findAll", query = "SELECT a FROM Authorities a")
    , @NamedQuery(name = "Authorities.findByIdauthorities", query = "SELECT a FROM Authorities a WHERE a.idauthorities = :idauthorities")})
public class Authorities implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idauthorities", nullable = false)
    private Integer idauthorities;
    @JoinColumn(name = "idrol", referencedColumnName = "idrol")
    @ManyToOne(fetch = FetchType.EAGER)
    private Roles idrol;
    @JoinColumn(name = "iduser", referencedColumnName = "idusuario")
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario iduser;

    public Authorities() {
    }

    public Authorities(Integer idauthorities) {
        this.idauthorities = idauthorities;
    }

    public Integer getIdauthorities() {
        return idauthorities;
    }

    public void setIdauthorities(Integer idauthorities) {
        this.idauthorities = idauthorities;
    }

    public Roles getIdrol() {
        return idrol;
    }

    public void setIdrol(Roles idrol) {
        this.idrol = idrol;
    }

    public Usuario getIduser() {
        return iduser;
    }

    public void setIduser(Usuario iduser) {
        this.iduser = iduser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idauthorities != null ? idauthorities.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Authorities)) {
            return false;
        }
        Authorities other = (Authorities) object;
        if ((this.idauthorities == null && other.idauthorities != null) || (this.idauthorities != null && !this.idauthorities.equals(other.idauthorities))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.edu.cibertec.spring.bean2.Authorities[ idauthorities=" + idauthorities + " ]";
    }
    
}
