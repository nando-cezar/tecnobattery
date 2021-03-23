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
public class ClientResponse implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private Long id;
  private String cnpj;
  private String name;
  private String fantasyName;
  private String phoneNumber;
  private String email;
  private AddressResponse address;

}
