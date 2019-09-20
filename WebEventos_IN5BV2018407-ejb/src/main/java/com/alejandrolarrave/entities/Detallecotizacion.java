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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author programacion
 */
@Entity
@Table(name = "detallecotizacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallecotizacion.findAll", query = "SELECT d FROM Detallecotizacion d")
    , @NamedQuery(name = "Detallecotizacion.findByIddetallecotizacion", query = "SELECT d FROM Detallecotizacion d WHERE d.iddetallecotizacion = :iddetallecotizacion")
    , @NamedQuery(name = "Detallecotizacion.findByIdproductos", query = "SELECT d FROM Detallecotizacion d WHERE d.idproductos = :idproductos")
    , @NamedQuery(name = "Detallecotizacion.findByCantidad", query = "SELECT d FROM Detallecotizacion d WHERE d.cantidad = :cantidad")
    , @NamedQuery(name = "Detallecotizacion.findByPrecio", query = "SELECT d FROM Detallecotizacion d WHERE d.precio = :precio")})
public class Detallecotizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddetallecotizacion")
    private Integer iddetallecotizacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idproductos")
    private int idproductos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private double precio;

    public Detallecotizacion() {
    }

    public Detallecotizacion(Integer iddetallecotizacion) {
        this.iddetallecotizacion = iddetallecotizacion;
    }

    public Detallecotizacion(Integer iddetallecotizacion, int idproductos, int cantidad, double precio) {
        this.iddetallecotizacion = iddetallecotizacion;
        this.idproductos = idproductos;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Integer getIddetallecotizacion() {
        return iddetallecotizacion;
    }

    public void setIddetallecotizacion(Integer iddetallecotizacion) {
        this.iddetallecotizacion = iddetallecotizacion;
    }

    public int getIdproductos() {
        return idproductos;
    }

    public void setIdproductos(int idproductos) {
        this.idproductos = idproductos;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddetallecotizacion != null ? iddetallecotizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detallecotizacion)) {
            return false;
        }
        Detallecotizacion other = (Detallecotizacion) object;
        if ((this.iddetallecotizacion == null && other.iddetallecotizacion != null) || (this.iddetallecotizacion != null && !this.iddetallecotizacion.equals(other.iddetallecotizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.alejandrolarrave.entities.Detallecotizacion[ iddetallecotizacion=" + iddetallecotizacion + " ]";
    }
    
}
