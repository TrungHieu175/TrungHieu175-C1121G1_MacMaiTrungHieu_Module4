package com.example.service.contract;

import com.example.model.contract.ContractDetail;
import com.example.model.employee.EducationDegree;

import java.util.List;

public interface IContractDetailService {

    List<ContractDetail> findAll();
}
