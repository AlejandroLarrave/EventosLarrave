/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alejandrolarrave.sessionsBeans;

import com.alejandrolarrave.entities.Tipoproductos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author programacion
 */
@Stateless
public class TipoproductosFacade extends AbstractFacade<Tipoproductos> implements TipoproductosFacadeLocal {

    @PersistenceContext(unitName = "WebEventos_IN5BV2018407PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoproductosFacade() {
        super(Tipoproductos.class);
    }
    
}
