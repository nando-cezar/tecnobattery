package com.tecnobattery.tbsystem.dto.response;

import java.io.Serializable;

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
public class BoardResponse implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private Long id;
  private String brand;
  private String model;
  private Integer power;
  private Integer voltage;
  private Integer width;
  private Integer height;
  private Integer length;
  private Integer weight;
  private String imageUrl;

}
