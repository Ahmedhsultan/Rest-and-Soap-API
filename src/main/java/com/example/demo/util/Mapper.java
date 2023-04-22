package com.example.demo.util;

import org.modelmapper.ModelMapper;

public enum Mapper {
    MAPPER;
    final ModelMapper modelMapper = new ModelMapper();
    public ModelMapper getModelMapper() {
        return modelMapper;
    }
}
