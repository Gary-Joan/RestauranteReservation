package com.garyortiz.org.restaurantReservation.domain.entity.mongo;


import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Document(collection = "booking")
public class Booking {

    @Id
    private String id;

    private String restauranteId;
    private String mesaId;
    private String usuarioId;
    private LocalDateTime fechaHoraReserva;
    private String estado;

    // Getters y setters
}
