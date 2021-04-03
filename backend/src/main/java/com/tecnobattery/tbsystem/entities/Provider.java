package com.tecnobattery.tbsystem.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
  private String phoneNumber;
  private String email;
  @OneToOne(cascade = CascadeType.ALL)
  private Address address;

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinTable(name = "tb_provider_telephone", joinColumns = @JoinColumn(name = "provider_id"), inverseJoinColumns = @JoinColumn(name = "telephone_id"))
  private Set<Telephone> telephones = new HashSet<>();

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinTable(name = "tb_provider_email", joinColumns = @JoinColumn(name = "provider_id"), inverseJoinColumns = @JoinColumn(name = "email_id"))
  private Set<Email> emails = new HashSet<>();

  public Provider(String name, String fantasyName, String cnpj, String phoneNumber, String email, Address address,
      Set<Telephone> telephones, Set<Email> emails) {
    this.name = name;
    this.fantasyName = fantasyName;
    this.cnpj = cnpj;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.address = address;
    this.telephones = telephones;
    this.emails = emails;
  }

}
