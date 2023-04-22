package com.example.demo.util;

import org.modelmapper.ModelMapper;

public enum Mapper {
    MAPPER;
    volatile ModelMapper modelMapper = new ModelMapper();
    public ModelMapper getModelMapper() {
        return modelMapper;
    }
}
