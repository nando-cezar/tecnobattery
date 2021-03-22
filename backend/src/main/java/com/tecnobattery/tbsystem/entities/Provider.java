package com.tecnobattery.tbsystem.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
@Table(name = "tb_provider")
public class Provider implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String fantasyName;
  private String cnpj;
  private String phone;
  @NotBlank
  @Email
  @Size(max = 255)
  private String email;
  @OneToOne(cascade = CascadeType.ALL)
  private Address address;

  public Provider(String name, String fantasyName, String cnpj, String phone, String email, Address address) {
    this.name = name;
    this.fantasyName = fantasyName;
    this.cnpj = cnpj;
    this.phone = phone;
    this.email = email;
    this.address = address;
  }

}
