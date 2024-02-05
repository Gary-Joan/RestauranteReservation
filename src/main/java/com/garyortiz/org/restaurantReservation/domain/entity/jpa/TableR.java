package com.garyortiz.org.restaurantReservation.domain.entity.jpa;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class TableR {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurante;

    private Integer capacidad;
    private String estado;

    // Getters y setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Restaurant getRestaurant() {
        return restaurante;
    }

    public Integer getRestaurantID(){ return restaurante.getId();}

    public void setRestaurant(Restaurant restaurante) {
        this.restaurante = restaurante;
    }

    public Integer getCapacity() {
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
