package com.alejandrolarrave.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2019-09-19T16:38:47")
@StaticMetamodel(Reservacion.class)
public class Reservacion_ { 

    public static volatile SingularAttribute<Reservacion, Integer> idsalon;
    public static volatile SingularAttribute<Reservacion, Date> fechainicial;
    public static volatile SingularAttribute<Reservacion, Integer> idsucursal;
    public static volatile SingularAttribute<Reservacion, Integer> idmotivoreservacion;
    public static volatile SingularAttribute<Reservacion, Integer> idreservacion;
    public static volatile SingularAttribute<Reservacion, Date> fechafinal;
    public static volatile SingularAttribute<Reservacion, Integer> idcliente;

}