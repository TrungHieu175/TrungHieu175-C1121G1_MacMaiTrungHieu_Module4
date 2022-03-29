package com.codegym.service.impl;

import com.codegym.service.IConverteService;
import org.springframework.stereotype.Service;

@Service
public class ConverteService implements IConverteService {
    @Override
    public int converteUsd(int a) {
        return  a * 23000;
    }
}
