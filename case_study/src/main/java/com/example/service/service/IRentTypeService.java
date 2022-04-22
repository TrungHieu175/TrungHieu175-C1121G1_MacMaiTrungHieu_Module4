package com.example.service.service;

import com.example.model.service.RentType;
import com.example.model.service.Service;
import com.example.model.service.ServiceType;

import java.util.List;

public interface IRentTypeService {

    List<RentType> findAll();
}
