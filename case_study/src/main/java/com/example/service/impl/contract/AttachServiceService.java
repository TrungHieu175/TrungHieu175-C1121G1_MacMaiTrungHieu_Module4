package com.example.service.impl.contract;

import com.example.model.contract.AttachService;
import com.example.model.employee.Division;
import com.example.repository.contract.IAttachServiceRepository;
import com.example.repository.employee.IDivisionRepository;
import com.example.service.contract.IAttachServiceService;
import com.example.service.employee.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachServiceService implements IAttachServiceService {

    @Autowired
    private IAttachServiceRepository iAttachServiceRepository;

    @Override
    public List<AttachService> findAll() {
        return iAttachServiceRepository.findAll();
    }
}
