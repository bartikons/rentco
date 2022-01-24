package com.rentco.demo.command;

import java.sql.Date;

public class ReservationCommand {
    private Integer id;
    private Integer price;
    private Integer tenantId;
    private Integer landlordId;
    private Date dateFrom;
    private Date dateTo;
    private Integer rentroomId;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return this.price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getTenantId() {
        return this.tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    public Integer getLandlordId() {
        return this.landlordId;
    }

    public void setLandlordId(Integer landlordId) {
        this.landlordId = landlordId;
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

    public Integer getRentroomId() {
        return this.rentroomId;
    }

    public void setRentroomId(Integer rentroomId) {
        this.rentroomId = rentroomId;
    }

}
