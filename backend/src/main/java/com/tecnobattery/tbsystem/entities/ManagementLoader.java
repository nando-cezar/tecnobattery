package com.tecnobattery.tbsystem.entities;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_management_loader")
public class ManagementLoader implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne
  private Provider provider;
  @OneToOne(cascade = CascadeType.ALL)
  private Loader loader;
  private OffsetDateTime moment;
  private Integer amount;

  public ManagementLoader() {
  }

  public ManagementLoader(Long id, Provider provider, Loader loader, OffsetDateTime moment, Integer amount) {
    this.id = id;
    this.provider = provider;
    this.loader = loader;
    this.moment = moment;
    this.amount = amount;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Provider getProvider() {
    return this.provider;
  }

  public void setProvider(Provider provider) {
    this.provider = provider;
  }

  public Loader getLoader() {
    return this.loader;
  }

  public void setLoader(Loader loader) {
    this.loader = loader;
  }

  public OffsetDateTime getMoment() {
    return this.moment;
  }

  public void setMoment(OffsetDateTime moment) {
    this.moment = moment;
  }

  public Integer getAmount() {
    return this.amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof ManagementLoader)) {
      return false;
    }
    ManagementLoader managementLoader = (ManagementLoader) o;
    return Objects.equals(id, managementLoader.id) && Objects.equals(provider, managementLoader.provider)
        && Objects.equals(loader, managementLoader.loader) && Objects.equals(moment, managementLoader.moment)
        && Objects.equals(amount, managementLoader.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, provider, loader, moment, amount);
  }

  @Override
  public String toString() {
    return "{" + " id='" + getId() + "'" + ", provider='" + getProvider() + "'" + ", loader='" + getLoader() + "'"
        + ", moment='" + getMoment() + "'" + ", amount='" + getAmount() + "'" + "}";
  }

}
