package com.tecnobattery.tbsystem.tools;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class ToolModelMapper {

    @Autowired
    private ModelMapper modelMapper;

    public <S, T> T toModel(S source, Class<T> destinationType) {
        return modelMapper.map(source, destinationType);
    }

    public <S, T> List<T> toCollection(List<S> source, Class<T> destinationType) {
        return source.stream().map(element -> toModel(element, destinationType)).collect(Collectors.toList());
    }

    public <S, T> Set<T> toCollection(Set<S> source, Class<T> destinationType) {
        return source.stream().map(element -> toModel(element, destinationType)).collect(Collectors.toSet());
    }
}
