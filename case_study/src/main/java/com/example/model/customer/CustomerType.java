package com.example.model.customer;

import javax.persistence.*;
import java.util.List;

@Entity
public class CustomerType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerTypeId;
    private String typeName;

    @OneToMany(mappedBy = "customerType")
    private List<Customer> customerList;

    public CustomerType() {
    }

    public Integer getId() {
        return customerTypeId;
    }

    public void setId(Integer id) {
        this.customerTypeId = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(Integer customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
