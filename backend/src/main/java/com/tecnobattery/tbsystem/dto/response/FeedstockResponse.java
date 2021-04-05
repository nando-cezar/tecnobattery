package com.tecnobattery.tbsystem.dto.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@JsonInclude(Include.NON_NULL)
public class FeedstockResponse implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private Long id;
  private String brand;
  private String model;
  private CategoryResponse category;
  private Integer capacity;
  private Integer voltage;
  private Integer power;
  private Integer diameter;
  private Integer height;
  private Integer width;
  private Integer length;
  private Integer weight;
  private String imageUrl;
  private String description;

}