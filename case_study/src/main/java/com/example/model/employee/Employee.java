package com.example.model.employee;

import com.example.model.security.AppUser;

import javax.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;
    private String name;
    private String birthday;
    private String idCard;
    private Integer salary;
    private String phone;
    private String email;
    private String address;

    @ManyToOne
    @JoinColumn(name = "app_user_id",referencedColumnName = "User_Name")
    private AppUser appUser;

    @ManyToOne
    @JoinColumn(name = "position_id",referencedColumnName = "positionId")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "education_degree_id",referencedColumnName = "educationDegreeId")
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "division_id",referencedColumnName = "divisionId")
    private Division division;

    public Employee() {
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
