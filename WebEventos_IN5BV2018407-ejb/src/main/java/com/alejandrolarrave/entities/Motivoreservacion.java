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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author programacion
 */
@Entity
@Table(name = "motivoreservacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Motivoreservacion.findAll", query = "SELECT m FROM Motivoreservacion m")
    , @NamedQuery(name = "Motivoreservacion.findByIdmotivoreservacion", query = "SELECT m FROM Motivoreservacion m WHERE m.idmotivoreservacion = :idmotivoreservacion")
    , @NamedQuery(name = "Motivoreservacion.findByCumpleanos", query = "SELECT m FROM Motivoreservacion m WHERE m.cumpleanos = :cumpleanos")
    , @NamedQuery(name = "Motivoreservacion.findByReuniontrabajo", query = "SELECT m FROM Motivoreservacion m WHERE m.reuniontrabajo = :reuniontrabajo")
    , @NamedQuery(name = "Motivoreservacion.findByCasamiento", query = "SELECT m FROM Motivoreservacion m WHERE m.casamiento = :casamiento")
    , @NamedQuery(name = "Motivoreservacion.findByOtro", query = "SELECT m FROM Motivoreservacion m WHERE m.otro = :otro")})
public class Motivoreservacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmotivoreservacion")
    private Integer idmotivoreservacion;
    @Column(name = "cumpleanos")
    private Short cumpleanos;
    @Column(name = "reuniontrabajo")
    private Short reuniontrabajo;
    @Column(name = "casamiento")
    private Short casamiento;
    @Size(max = 100)
    @Column(name = "otro")
    private String otro;

    public Motivoreservacion() {
    }

    public Motivoreservacion(Integer idmotivoreservacion) {
        this.idmotivoreservacion = idmotivoreservacion;
    }

    public Integer getIdmotivoreservacion() {
        return idmotivoreservacion;
    }

    public void setIdmotivoreservacion(Integer idmotivoreservacion) {
        this.idmotivoreservacion = idmotivoreservacion;
    }

    public Short getCumpleanos() {
        return cumpleanos;
    }

    public void setCumpleanos(Short cumpleanos) {
        this.cumpleanos = cumpleanos;
    }

    public Short getReuniontrabajo() {
        return reuniontrabajo;
    }

    public void setReuniontrabajo(Short reuniontrabajo) {
        this.reuniontrabajo = reuniontrabajo;
    }

    public Short getCasamiento() {
        return casamiento;
    }

    public void setCasamiento(Short casamiento) {
        this.casamiento = casamiento;
    }

    public String getOtro() {
        return otro;
    }

    public void setOtro(String otro) {
        this.otro = otro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmotivoreservacion != null ? idmotivoreservacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Motivoreservacion)) {
            return false;
        }
        Motivoreservacion other = (Motivoreservacion) object;
        if ((this.idmotivoreservacion == null && other.idmotivoreservacion != null) || (this.idmotivoreservacion != null && !this.idmotivoreservacion.equals(other.idmotivoreservacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.alejandrolarrave.entities.Motivoreservacion[ idmotivoreservacion=" + idmotivoreservacion + " ]";
    }
    
}
