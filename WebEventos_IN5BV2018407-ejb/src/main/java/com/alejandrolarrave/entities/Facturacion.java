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
@Table(name = "facturacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Facturacion.findAll", query = "SELECT f FROM Facturacion f")
    , @NamedQuery(name = "Facturacion.findByIdfacturacion", query = "SELECT f FROM Facturacion f WHERE f.idfacturacion = :idfacturacion")
    , @NamedQuery(name = "Facturacion.findByDescripcion", query = "SELECT f FROM Facturacion f WHERE f.descripcion = :descripcion")
    , @NamedQuery(name = "Facturacion.findByIdcotizacion", query = "SELECT f FROM Facturacion f WHERE f.idcotizacion = :idcotizacion")})
public class Facturacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfacturacion")
    private Integer idfacturacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcotizacion")
    private int idcotizacion;

    public Facturacion() {
    }

    public Facturacion(Integer idfacturacion) {
        this.idfacturacion = idfacturacion;
    }

    public Facturacion(Integer idfacturacion, String descripcion, int idcotizacion) {
        this.idfacturacion = idfacturacion;
        this.descripcion = descripcion;
        this.idcotizacion = idcotizacion;
    }

    public Integer getIdfacturacion() {
        return idfacturacion;
    }

    public void setIdfacturacion(Integer idfacturacion) {
        this.idfacturacion = idfacturacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdcotizacion() {
        return idcotizacion;
    }

    public void setIdcotizacion(int idcotizacion) {
        this.idcotizacion = idcotizacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfacturacion != null ? idfacturacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facturacion)) {
            return false;
        }
        Facturacion other = (Facturacion) object;
        if ((this.idfacturacion == null && other.idfacturacion != null) || (this.idfacturacion != null && !this.idfacturacion.equals(other.idfacturacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.alejandrolarrave.entities.Facturacion[ idfacturacion=" + idfacturacion + " ]";
    }
    
}
