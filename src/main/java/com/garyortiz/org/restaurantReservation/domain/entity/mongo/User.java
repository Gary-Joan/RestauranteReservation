package com.garyortiz.org.restaurantReservation.domain.entity.mongo;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {
    @Id
    private String id;

    private String nombre;
    private String correoElectronico;
    private String contraseña;
    private String rol;

    public void setName(String name) {
        this.nombre= name;
    }
    public void setId(String id){this.id=id;}
    public String getName() {
        return this.nombre;
    }

    public String getId() {
        return this.id;
    }

    // Getters y setters
}
