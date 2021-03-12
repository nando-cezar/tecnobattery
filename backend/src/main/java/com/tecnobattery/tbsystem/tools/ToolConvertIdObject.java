package com.tecnobattery.tbsystem.tools;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

public class ToolConvertIdObject {

  @Autowired
  private ToolModelMapper toolModelMapper;

  public <I, S, T> List<T> getObjectId(List<I> input, S service, Class<T> destinationType) {

    List<Object> id = input.stream().map(x -> {
      return x;
    }).collect(Collectors.toList());

    List<Long> idConvert = new ArrayList<>();

    for (int i = 0; i < id.size(); i++) {
      idConvert.add(Long.parseLong(id.get(i).toString()));
    }

    return toolModelMapper.toCollection(idConvert.stream().map(x -> {
      try {
        return service.getClass().getDeclaredMethod("findById", Long.class).invoke(service, x);
      } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
          | SecurityException e) {
        e.printStackTrace();
      }
      return x;
    }).collect(Collectors.toList()), destinationType);

  }

  public <I, S, T> Set<T> getObjectId(Set<I> input, S service, Class<T> destinationType) {

    List<Object> id = input.stream().map(x -> {
      return x;
    }).collect(Collectors.toList());

    List<Long> idConvert = new ArrayList<>();

    for (int i = 0; i < id.size(); i++) {
      idConvert.add(Long.parseLong(id.get(i).toString()));
    }

    return toolModelMapper.toCollection(idConvert.stream().map(x -> {
      try {
        return service.getClass().getDeclaredMethod("findById", Long.class).invoke(service, x);
      } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
          | SecurityException e) {
        e.printStackTrace();
      }
      return x;
    }).collect(Collectors.toSet()), destinationType);

  }
}
