package com.tecnobattery.tbsystem.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

public class Problem {

  private Integer status;
  private String title;
  private LocalDateTime moment;
  private List<Field> fields;

  public static class Field {
    private String name;
    private String message;

    public Field(String name, String message) {
      this.name = name;
      this.message = message;
    }

    public String getName() {
      return this.name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getMessage() {
      return this.message;
    }

    public void setMessage(String message) {
      this.message = message;
    }

  }

  public Integer getStatus() {
    return this.status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public LocalDateTime getMoment() {
    return this.moment;
  }

  public void setMoment(LocalDateTime moment) {
    this.moment = moment;
  }

  public List<Field> getFields() {
    return this.fields;
  }

  public void setFields(List<Field> fields) {
    this.fields = fields;
  }

}
