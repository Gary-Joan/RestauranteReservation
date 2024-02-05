package com.garyortiz.org.restaurantReservation.domain.entity.mongo;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "restaurant")
public class Restaurant {

    @Id
    private String id;

    private String nombre;
    private String direccion;
    private String telefono;
    private String horarioApertura;
    private String horarioCierre;
}
