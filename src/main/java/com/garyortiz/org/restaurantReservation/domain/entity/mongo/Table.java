package com.garyortiz.org.restaurantReservation.domain.entity.mongo;


import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "table")
public class Table {
    @Id
    private String id;

    private String restauranteId;
    private int capacidad;
    private String estado;

    // Getters y setters
}
