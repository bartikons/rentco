package com.rentco.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "RENT_ROOM")
public class RentRoomModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", columnDefinition = "Decimal(10,2)", nullable = false)
    private float price;

    @Column(name = "area", columnDefinition = "INTEGER", nullable = false)
    private String area;

    @Column(name = "Description")
    private String description;

    @Column(name = "landlord_id", nullable = false)
    private Integer landlordOfRoom;

    public RentRoomModel() {
    }

    public RentRoomModel(Integer id, String name, float price, String area, String description,
                         Integer landlordOfRoom) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.area = area;
        this.description = description;
        this.landlordOfRoom = landlordOfRoom;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLandlordOfRoom() {
        return this.landlordOfRoom;
    }

    public void setLandlordOfRoom(Integer landlordOfRoom) {
        this.landlordOfRoom = landlordOfRoom;
    }

    public RentRoomModel id(Integer id) {
        setId(id);
        return this;
    }

    public RentRoomModel name(String name) {
        setName(name);
        return this;
    }

    public RentRoomModel price(float price) {
        setPrice(price);
        return this;
    }

    public RentRoomModel area(String area) {
        setArea(area);
        return this;
    }

    public RentRoomModel description(String description) {
        setDescription(description);
        return this;
    }

    public RentRoomModel landlordOfRoom(Integer landlordOfRoom) {
        setLandlordOfRoom(landlordOfRoom);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", price='" + getPrice() + "'" +
                ", area='" + getArea() + "'" +
                ", description='" + getDescription() + "'" +
                ", landlordOfRoom='" + getLandlordOfRoom() + "'" +
                "}";
    }

}
