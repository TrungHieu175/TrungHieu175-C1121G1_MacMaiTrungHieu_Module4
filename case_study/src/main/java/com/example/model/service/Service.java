package com.example.model.service;

import com.example.model.contract.Contract;

import javax.persistence.*;
import java.util.List;

@Entity
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer serviceId;
    private String name;
    private Integer area;
    private Integer cost;
    private Integer maxPeople;
    private String standardRoom;
    private String convenience;
    private Integer poolArea;
    private Integer floor;

    @OneToMany(mappedBy = "service")
    private List<Contract> contract;

    @ManyToOne
    @JoinColumn(name = "service_type_id",referencedColumnName = "serviceTypeId")
    private ServiceType serviceType;

    @ManyToOne
    @JoinColumn(name = "rent_type_id",referencedColumnName = "rentTypeId")
    private RentType rentType;



    public Service() {
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getConvenience() {
        return convenience;
    }

    public void setConvenience(String convenience) {
        this.convenience = convenience;
    }

    public Integer getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Integer poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public List<Contract> getContract() {
        return contract;
    }

    public void setContract(List<Contract> contract) {
        this.contract = contract;
    }
}
