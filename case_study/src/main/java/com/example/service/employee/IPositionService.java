package com.example.service.employee;

import com.example.model.employee.Position;
import com.example.model.service.RentType;

import java.util.List;

public interface IPositionService {

    List<Position> findAll();
}
