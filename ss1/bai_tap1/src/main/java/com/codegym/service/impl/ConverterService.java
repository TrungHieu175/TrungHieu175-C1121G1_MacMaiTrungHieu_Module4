package com.codegym.service.impl;

import com.codegym.service.IConverterService;
import org.springframework.stereotype.Service;

@Service
public class ConverterService implements IConverterService {
    @Override
    public int converterUsd(int a) {
        return  a * 23000;
    }
}
