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
public class ProductResponse implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private Long id;
  private String name;
  private Integer power;
  private Integer capacity;
  private Integer voltage;
  private Double price;
  private String description;
  private String imageUrl;

}
