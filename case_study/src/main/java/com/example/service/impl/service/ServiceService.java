package com.example.service.impl.service;

import com.example.model.service.Service;
import com.example.repository.service.IServiceRepository;
import com.example.service.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceService implements IServiceService {

    @Autowired
    private IServiceRepository iServiceRepository;

    @Override
    public List<Service> findAll() {
        return iServiceRepository.findAll();
    }

    @Override
    public void save(Service service) {
        iServiceRepository.save(service);
    }

    @Override
    public void deleteById(Integer id) {
        iServiceRepository.deleteById(id);
    }

    @Override
    public Service findById(Integer id) {
        return iServiceRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Service> findAllPaging(String keyword, Pageable pageable) {
        return iServiceRepository.findAllByNameContaining(keyword,pageable);
    }

    @Override
    public Page<Service> findAllService(Pageable pageable) {
        return iServiceRepository.findAllByOrderByName(pageable);
    }
}
