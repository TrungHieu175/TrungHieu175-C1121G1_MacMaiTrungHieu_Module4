package com.example.model.service;

import javax.persistence.*;
import java.util.List;

@Entity
public class RentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rentTypeId;
    private String name;
    private Integer cost;

    @OneToMany(mappedBy = "rentType")
    private List<Service> serviceList;

    public RentType() {
    }

    public Integer getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(Integer rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public List<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }
}
