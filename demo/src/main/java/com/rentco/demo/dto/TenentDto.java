package com.rentco.demo.dto;

import com.rentco.demo.model.TenantModel;

public class TenentDto {

    private Integer id;
    private String name;

    public TenentDto() {
    }

    public TenentDto(TenantModel tenant) {
        this.id = tenant.getId();
        this.name = tenant.getName();
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
}

