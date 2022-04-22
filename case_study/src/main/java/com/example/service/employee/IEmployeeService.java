package com.example.service.employee;

import com.example.model.employee.Employee;
import com.example.model.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {

    List<Employee> findAll();

    void save(Employee employee);

    void deleteById(Integer id);

    Employee findById(Integer id);

    Page<Employee> findAllPaging(String keyword, Pageable pageable);

    Page<Employee> findAllEmployee(Pageable pageable);
}
