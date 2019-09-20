/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alejandrolarrave.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author programacion
 */
@Entity
@Table(name = "cotizacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cotizacion.findAll", query = "SELECT c FROM Cotizacion c")
    , @NamedQuery(name = "Cotizacion.findByIdcotizacion", query = "SELECT c FROM Cotizacion c WHERE c.idcotizacion = :idcotizacion")
    , @NamedQuery(name = "Cotizacion.findByFechacotizacion", query = "SELECT c FROM Cotizacion c WHERE c.fechacotizacion = :fechacotizacion")
    , @NamedQuery(name = "Cotizacion.findByIdreservacion", query = "SELECT c FROM Cotizacion c WHERE c.idreservacion = :idreservacion")
    , @NamedQuery(name = "Cotizacion.findByIddetallecotizacion", query = "SELECT c FROM Cotizacion c WHERE c.iddetallecotizacion = :iddetallecotizacion")})
public class Cotizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcotizacion")
    private Integer idcotizacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechacotizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacotizacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idreservacion")
    private int idreservacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iddetallecotizacion")
    private int iddetallecotizacion;

    public Cotizacion() {
    }

    public Cotizacion(Integer idcotizacion) {
        this.idcotizacion = idcotizacion;
    }

    public Cotizacion(Integer idcotizacion, Date fechacotizacion, int idreservacion, int iddetallecotizacion) {
        this.idcotizacion = idcotizacion;
        this.fechacotizacion = fechacotizacion;
        this.idreservacion = idreservacion;
        this.iddetallecotizacion = iddetallecotizacion;
    }

    public Integer getIdcotizacion() {
        return idcotizacion;
    }

    public void setIdcotizacion(Integer idcotizacion) {
        this.idcotizacion = idcotizacion;
    }

    public Date getFechacotizacion() {
        return fechacotizacion;
    }

    public void setFechacotizacion(Date fechacotizacion) {
        this.fechacotizacion = fechacotizacion;
    }

    public int getIdreservacion() {
        return idreservacion;
    }

    public void setIdreservacion(int idreservacion) {
        this.idreservacion = idreservacion;
    }

    public int getIddetallecotizacion() {
        return iddetallecotizacion;
    }

    public void setIddetallecotizacion(int iddetallecotizacion) {
        this.iddetallecotizacion = iddetallecotizacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcotizacion != null ? idcotizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cotizacion)) {
            return false;
        }
        Cotizacion other = (Cotizacion) object;
        if ((this.idcotizacion == null && other.idcotizacion != null) || (this.idcotizacion != null && !this.idcotizacion.equals(other.idcotizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.alejandrolarrave.entities.Cotizacion[ idcotizacion=" + idcotizacion + " ]";
    }
    
}
