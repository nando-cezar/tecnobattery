package com.tecnobattery.tbsystem.error.exceptionhandler.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class Problem {

  private Integer status;
  private String title;
  private LocalDateTime moment;
  private List<Field> fields;

}
