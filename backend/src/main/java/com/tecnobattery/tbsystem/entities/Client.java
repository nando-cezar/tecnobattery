package com.tecnobattery.tbsystem.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tb_client")
public class Client implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String cnpj;
  private String name;
  private String fantasyName;
  private String phoneNumber;
  private String email;
  @OneToOne(cascade = CascadeType.ALL)
  private Address address;

  public Client(String cnpj, String name, String fantasyName, String phoneNumber, String email, Address address) {
    this.cnpj = cnpj;
    this.name = name;
    this.fantasyName = fantasyName;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.address = address;
  }

}
