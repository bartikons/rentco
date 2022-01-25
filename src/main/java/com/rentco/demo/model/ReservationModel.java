package com.rentco.demo.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "RESERVATION")
public class ReservationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "price", columnDefinition = "Decimal(10,2)", nullable = false)
    private float price;

    @Column(name = "landlord_id", nullable = false)
    private Integer landlord;

    @Column(name = "date_from", columnDefinition = "DATE", nullable = false)
    private Date dateFrom;
    @Column(name = "date_to", columnDefinition = "DATE", nullable = false)
    private Date dateTo;

    @ManyToOne
    @JoinColumn(name = "rent_room_id")
    private RentRoomModel rentroom;

    @ManyToOne
    @JoinColumn(name = "tenant_id")
    private TenantModel tenant;

    public ReservationModel() {
    }

    public ReservationModel(float price, TenantModel tenant, Integer landlord, Date dateFrom, Date dateTo,
                            RentRoomModel rentroom) {
        this.price = price;
        this.tenant = tenant;
        this.landlord = landlord;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.rentroom = rentroom;
    }

    public ReservationModel(Integer id, float price, TenantModel tenant, Integer landlord, Date dateFrom, Date dateTo,
                            RentRoomModel rentroom) {
        this.id = id;
        this.price = price;
        this.tenant = tenant;
        this.landlord = landlord;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.rentroom = rentroom;
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

    public TenantModel getTenant() {
        return this.tenant;
    }

    public void setTenant(TenantModel tenant) {
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

    public RentRoomModel getRentRoom() {
        return this.rentroom;
    }

    public void setRentRoom(RentRoomModel rentroom) {
        this.rentroom = rentroom;
    }

    public ReservationModel id(Integer id) {
        setId(id);
        return this;
    }

    public ReservationModel price(float price) {
        setPrice(price);
        return this;
    }

    public ReservationModel tenant(TenantModel tenant) {
        setTenant(tenant);
        return this;
    }

    public ReservationModel landlord(Integer landlord) {
        setLandlord(landlord);
        return this;
    }

    public ReservationModel dateFrom(Date dateFrom) {
        setDateFrom(dateFrom);
        return this;
    }

    public ReservationModel dateTo(Date dateTo) {
        setDateTo(dateTo);
        return this;
    }

    public ReservationModel rentroom(RentRoomModel rentroom) {
        setRentRoom(rentroom);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", price='" + getPrice() + "'" +
                ", tenant='" + getTenant() + "'" +
                ", landlord='" + getLandlord() + "'" +
                ", dateFrom='" + getDateFrom() + "'" +
                ", dateTo='" + getDateTo() + "'" +
                ", rentroom='" + getRentRoom() + "'" +
                "}";
    }

}