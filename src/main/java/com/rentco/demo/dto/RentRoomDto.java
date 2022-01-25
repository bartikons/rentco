package com.rentco.demo.dto;

import com.rentco.demo.model.RentRoomModel;

public class RentRoomDto {

    private Integer id;
    private String name;
    private float price;
    private String area;
    private String description;

    public RentRoomDto() {
    }

    public RentRoomDto(RentRoomModel rentRoom) {
        this.id = rentRoom.getId();
        this.name = rentRoom.getName();
        this.price = rentRoom.getPrice();
        this.area = rentRoom.getArea();
        this.description = rentRoom.getDescription();
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getArea() {
        return this.area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String Description) {
        this.description = Description;
    }
}
