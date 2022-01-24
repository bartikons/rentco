package com.rentco.demo.dto;

import java.sql.Date;

import com.rentco.demo.model.RentRoomModel;
import com.rentco.demo.model.ReservationModel;
import com.rentco.demo.model.TenantModel;

public class ReservationDto {

    private Integer id;
    private float price;
    private TenentDto tenant;
    private Integer landlord;
    private Date dateFrom;
    private Date dateTo;
    private RentRoomDto rentroom;

    public ReservationDto() {
    }

    public ReservationDto(ReservationModel reservation) {
        this.id = reservation.getId();
        this.price = reservation.getPrice();
        this.tenant = new TenentDto(reservation.getTenant());
        this.landlord = reservation.getLandlord();
        this.dateFrom = reservation.getDateFrom();
        this.dateTo = reservation.getDateTo();
        this.rentroom = new RentRoomDto(reservation.getRentRoom());
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public TenentDto getTenant() {
        return this.tenant;
    }

    public void setTenant(TenentDto tenant) {
        this.tenant = tenant;
    }

    public Integer getLandlord() {
        return this.landlord;
    }

    public void setLandlord(Integer landlord) {
        this.landlord = landlord;
    }

    public Date getDateFrom() {
        return this.dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return this.dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public RentRoomDto getRentroom() {
        return this.rentroom;
    }

    public void setRentroom(RentRoomDto rentroom) {
        this.rentroom = rentroom;
    }

}
