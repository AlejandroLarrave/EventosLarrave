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
@Table(name = "reservacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservacion.findAll", query = "SELECT r FROM Reservacion r")
    , @NamedQuery(name = "Reservacion.findByIdreservacion", query = "SELECT r FROM Reservacion r WHERE r.idreservacion = :idreservacion")
    , @NamedQuery(name = "Reservacion.findByIdsucursal", query = "SELECT r FROM Reservacion r WHERE r.idsucursal = :idsucursal")
    , @NamedQuery(name = "Reservacion.findByIdsalon", query = "SELECT r FROM Reservacion r WHERE r.idsalon = :idsalon")
    , @NamedQuery(name = "Reservacion.findByFechainicial", query = "SELECT r FROM Reservacion r WHERE r.fechainicial = :fechainicial")
    , @NamedQuery(name = "Reservacion.findByFechafinal", query = "SELECT r FROM Reservacion r WHERE r.fechafinal = :fechafinal")
    , @NamedQuery(name = "Reservacion.findByIdcliente", query = "SELECT r FROM Reservacion r WHERE r.idcliente = :idcliente")
    , @NamedQuery(name = "Reservacion.findByIdmotivoreservacion", query = "SELECT r FROM Reservacion r WHERE r.idmotivoreservacion = :idmotivoreservacion")})
public class Reservacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idreservacion")
    private Integer idreservacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idsucursal")
    private int idsucursal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idsalon")
    private int idsalon;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechainicial")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechainicial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechafinal")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechafinal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcliente")
    private int idcliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idmotivoreservacion")
    private int idmotivoreservacion;

    public Reservacion() {
    }

    public Reservacion(Integer idreservacion) {
        this.idreservacion = idreservacion;
    }

    public Reservacion(Integer idreservacion, int idsucursal, int idsalon, Date fechainicial, Date fechafinal, int idcliente, int idmotivoreservacion) {
        this.idreservacion = idreservacion;
        this.idsucursal = idsucursal;
        this.idsalon = idsalon;
        this.fechainicial = fechainicial;
        this.fechafinal = fechafinal;
        this.idcliente = idcliente;
        this.idmotivoreservacion = idmotivoreservacion;
    }

    public Integer getIdreservacion() {
        return idreservacion;
    }

    public void setIdreservacion(Integer idreservacion) {
        this.idreservacion = idreservacion;
    }

    public int getIdsucursal() {
        return idsucursal;
    }

    public void setIdsucursal(int idsucursal) {
        this.idsucursal = idsucursal;
    }

    public int getIdsalon() {
        return idsalon;
    }

    public void setIdsalon(int idsalon) {
        this.idsalon = idsalon;
    }

    public Date getFechainicial() {
        return fechainicial;
    }

    public void setFechainicial(Date fechainicial) {
        this.fechainicial = fechainicial;
    }

    public Date getFechafinal() {
        return fechafinal;
    }

    public void setFechafinal(Date fechafinal) {
        this.fechafinal = fechafinal;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdmotivoreservacion() {
        return idmotivoreservacion;
    }

    public void setIdmotivoreservacion(int idmotivoreservacion) {
        this.idmotivoreservacion = idmotivoreservacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idreservacion != null ? idreservacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservacion)) {
            return false;
        }
        Reservacion other = (Reservacion) object;
        if ((this.idreservacion == null && other.idreservacion != null) || (this.idreservacion != null && !this.idreservacion.equals(other.idreservacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.alejandrolarrave.entities.Reservacion[ idreservacion=" + idreservacion + " ]";
    }
    
}
