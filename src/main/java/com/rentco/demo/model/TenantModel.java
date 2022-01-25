package com.rentco.demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tenant")
public class TenantModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "tenant")
    private Set<ReservationModel> reservation;

    public TenantModel() {
    }

    public TenantModel(Integer id, String name, Set<ReservationModel> reservation) {
        this.id = id;
        this.name = name;
        this.reservation = reservation;
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

    public Set<ReservationModel> getReservation() {
        return this.reservation;
    }

    public void setReservation(Set<ReservationModel> reservation) {
        this.reservation = reservation;
    }

    public TenantModel id(Integer id) {
        setId(id);
        return this;
    }

    public TenantModel name(String name) {
        setName(name);
        return this;
    }

    public TenantModel reservation(Set<ReservationModel> reservation) {
        setReservation(reservation);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                "}";
    }

}
