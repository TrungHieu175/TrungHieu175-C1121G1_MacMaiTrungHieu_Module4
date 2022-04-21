package com.example.model.employee;

import javax.persistence.*;
import java.util.List;

@Entity
public class EducationDegree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer educationDegreeId;
    private String name;

    @OneToMany(mappedBy = "educationDegree")
    private List<Employee> employeeList;

    public EducationDegree() {
    }

    public Integer getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(Integer educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
