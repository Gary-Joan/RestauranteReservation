package com.garyortiz.org.restaurantReservation.domain.dto;


public class UserDto {
    private Object id;
    private String name;

    public UserDto(){}


    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
