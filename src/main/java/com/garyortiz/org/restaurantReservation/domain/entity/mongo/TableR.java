package com.garyortiz.org.restaurantReservation.domain.entity.mongo;


import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "table")
public class TableR {
    @Id
    private String id;

    private String restauranteId;
    private int capacidad;
    private String estado;

    // Getters y setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRestaurantId() {
        return restauranteId;
    }

    public void setRestaurantId(String restauranteId) {
        this.restauranteId = restauranteId;
    }

    public int getCapacity() {
        return capacidad;
    }

    public void setCapacity(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getStatus() {
        return estado;
    }

    public void setStatus(String estado) {
        this.estado = estado;
    }
}
