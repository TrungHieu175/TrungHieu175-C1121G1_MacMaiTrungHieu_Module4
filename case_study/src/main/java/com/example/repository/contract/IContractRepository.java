package com.example.repository.contract;

import com.example.model.contract.Contract;
import com.example.model.employee.Division;
import com.example.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractRepository extends JpaRepository<Contract,Integer> {

    Page<Contract> findAllByStarDateContaining(String name, Pageable pageable);

    Page<Contract> findAllByOrderByStarDate(Pageable pageable);
}
