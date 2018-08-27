/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bolsadeideas.springboot.app.models.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "roles", catalog = "qc_help_revision", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roles.findAll", query = "SELECT r FROM Roles r")
    , @NamedQuery(name = "Roles.findByIdrol", query = "SELECT r FROM Roles r WHERE r.idrol = :idrol")
    , @NamedQuery(name = "Roles.findByRolNombre", query = "SELECT r FROM Roles r WHERE r.rolNombre = :rolNombre")
    , @NamedQuery(name = "Roles.findByDescripcion", query = "SELECT r FROM Roles r WHERE r.descripcion = :descripcion")
    , @NamedQuery(name = "Roles.findByEstado", query = "SELECT r FROM Roles r WHERE r.estado = :estado")})
public class Roles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrol", nullable = false)
    private Integer idrol;
    @Size(max = 50)
    @Column(name = "rol_nombre", length = 50)
    private String rolNombre;
    @Size(max = 100)
    @Column(name = "descripcion", length = 100)
    private String descripcion;
    @Column(name = "estado")
    private Boolean estado;
    @OneToMany(mappedBy = "idrol", fetch = FetchType.EAGER)
    private List<Authorities> authoritiesList;

    public Roles() {
    }

    public Roles(Integer idrol) {
        this.idrol = idrol;
    }

    public Integer getIdrol() {
        return idrol;
    }

    public void setIdrol(Integer idrol) {
        this.idrol = idrol;
    }

    public String getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(String rolNombre) {
        this.rolNombre = rolNombre;
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

    @XmlTransient
    public List<Authorities> getAuthoritiesList() {
        return authoritiesList;
    }

    public void setAuthoritiesList(List<Authorities> authoritiesList) {
        this.authoritiesList = authoritiesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrol != null ? idrol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roles)) {
            return false;
        }
        Roles other = (Roles) object;
        if ((this.idrol == null && other.idrol != null) || (this.idrol != null && !this.idrol.equals(other.idrol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.edu.cibertec.spring.bean2.Roles[ idrol=" + idrol + " ]";
    }
    
}
