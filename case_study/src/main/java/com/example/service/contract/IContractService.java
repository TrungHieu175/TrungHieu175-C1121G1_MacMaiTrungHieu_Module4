package com.example.service.contract;

import com.example.model.contract.Contract;
import com.example.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {

    List<Contract> findAll();

    void save(Contract contract);

    void deleteById(Integer id);

    Contract findById(Integer id);

    Page<Contract> findAllPaging(String keyword, Pageable pageable);

    Page<Contract> findAllContract(Pageable pageable);
}
