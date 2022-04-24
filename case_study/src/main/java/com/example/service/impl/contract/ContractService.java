package com.example.service.impl.contract;

import com.example.model.contract.Contract;
import com.example.model.employee.Employee;
import com.example.repository.contract.IContractRepository;
import com.example.repository.employee.IEmployeeRepository;
import com.example.service.contract.IContractService;
import com.example.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {

    @Autowired
    private IContractRepository iContractRepository;

    @Override
    public List<Contract> findAll() {
        return iContractRepository.findAll();
    }

    @Override
    public void save(Contract contract) {
        iContractRepository.save(contract);
    }

    @Override
    public void deleteById(Integer id) {
        iContractRepository.deleteById(id);
    }

    @Override
    public Contract findById(Integer id) {
        return iContractRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Contract> findAllPaging(String keyword, Pageable pageable) {
        return iContractRepository.findAllByStarDateContaining(keyword, pageable);
    }

    @Override
    public Page<Contract> findAllContract(Pageable pageable) {
        return iContractRepository.findAllByOrderByStarDate(pageable);
    }

}
