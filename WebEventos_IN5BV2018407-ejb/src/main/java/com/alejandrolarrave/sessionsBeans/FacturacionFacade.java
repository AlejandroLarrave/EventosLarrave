/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alejandrolarrave.sessionsBeans;

import com.alejandrolarrave.entities.Facturacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author programacion
 */
@Stateless
public class FacturacionFacade extends AbstractFacade<Facturacion> implements FacturacionFacadeLocal {

    @PersistenceContext(unitName = "WebEventos_IN5BV2018407PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FacturacionFacade() {
        super(Facturacion.class);
    }
    
}
