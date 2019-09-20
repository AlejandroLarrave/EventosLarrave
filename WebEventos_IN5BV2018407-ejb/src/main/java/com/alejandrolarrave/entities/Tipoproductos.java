/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alejandrolarrave.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author programacion
 */
@Entity
@Table(name = "tipoproductos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoproductos.findAll", query = "SELECT t FROM Tipoproductos t")
    , @NamedQuery(name = "Tipoproductos.findByIdtipoproductos", query = "SELECT t FROM Tipoproductos t WHERE t.idtipoproductos = :idtipoproductos")
    , @NamedQuery(name = "Tipoproductos.findByDescripcion", query = "SELECT t FROM Tipoproductos t WHERE t.descripcion = :descripcion")})
public class Tipoproductos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipoproductos")
    private Integer idtipoproductos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion")
    private String descripcion;

    public Tipoproductos() {
    }

    public Tipoproductos(Integer idtipoproductos) {
        this.idtipoproductos = idtipoproductos;
    }

    public Tipoproductos(Integer idtipoproductos, String descripcion) {
        this.idtipoproductos = idtipoproductos;
        this.descripcion = descripcion;
    }

    public Integer getIdtipoproductos() {
        return idtipoproductos;
    }

    public void setIdtipoproductos(Integer idtipoproductos) {
        this.idtipoproductos = idtipoproductos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoproductos != null ? idtipoproductos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoproductos)) {
            return false;
        }
        Tipoproductos other = (Tipoproductos) object;
        if ((this.idtipoproductos == null && other.idtipoproductos != null) || (this.idtipoproductos != null && !this.idtipoproductos.equals(other.idtipoproductos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.alejandrolarrave.entities.Tipoproductos[ idtipoproductos=" + idtipoproductos + " ]";
    }
    
}
