package com.tecnobattery.tbsystem.dto.response;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.tecnobattery.tbsystem.entities.enumerated.OrderStatus;

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
public class OrderResponse implements Serializable {

  /** 
   *
   */
  private static final long serialVersionUID = 1L;
  private Long id;
  private ClientResponse client;
  private String description;
  private Double price;
  private OrderStatus status;
  private OffsetDateTime opening;
  private OffsetDateTime deadline;
  private Set<UserResponse> users = new HashSet<>();
  private Set<ProductResponse> products = new HashSet<>();

}
