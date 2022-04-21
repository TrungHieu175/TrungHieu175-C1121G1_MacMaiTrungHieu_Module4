package com.example.model.contract;

import com.example.model.customer.Customer;
import com.example.model.employee.Employee;
import com.example.model.service.Service;

import javax.persistence.*;
import java.util.List;

@Entity
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contractId;
    private String starDate;
    private String endDate;
    private Integer deposit;
    private Integer totalMoney;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customerId")
    private Customer customer;

    @OneToMany(mappedBy = "contract")
    private List<ContractDetail> contractDetailList;

    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "serviceId")
    private Service service;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employeeId")
    private Employee employee;

    public Contract() {
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public List<ContractDetail> getContractDetailList() {
        return contractDetailList;
    }

    public void setContractDetailList(List<ContractDetail> contractDetailList) {
        this.contractDetailList = contractDetailList;
    }

    public Integer getId() {
        return contractId;
    }

    public void setId(Integer id) {
        this.contractId = id;
    }

    public String getStarDate() {
        return starDate;
    }

    public void setStarDate(String starDate) {
        this.starDate = starDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getDeposit() {
        return deposit;
    }

    public void setDeposit(Integer deposit) {
        this.deposit = deposit;
    }

    public Integer getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Integer totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }


}
