/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alejandrolarrave.sessionsBeans;

import com.alejandrolarrave.entities.Motivoreservacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author programacion
 */
@Local
public interface MotivoreservacionFacadeLocal {

    void create(Motivoreservacion motivoreservacion);

    void edit(Motivoreservacion motivoreservacion);

    void remove(Motivoreservacion motivoreservacion);

    Motivoreservacion find(Object id);

    List<Motivoreservacion> findAll();

    List<Motivoreservacion> findRange(int[] range);

    int count();
    
}
