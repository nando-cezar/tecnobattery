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
@Table(name = "tb_management_battery")
public class ManagementBattery implements Serializable {

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
  private Battery battery;
  private OffsetDateTime moment;
  private Integer amount;

  public ManagementBattery() {
  }

  public ManagementBattery(Long id, Provider provider, Battery battery, OffsetDateTime moment, Integer amount) {
    this.id = id;
    this.provider = provider;
    this.battery = battery;
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

  public Battery getBattery() {
    return this.battery;
  }

  public void setBattery(Battery battery) {
    this.battery = battery;
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
    if (!(o instanceof ManagementBattery)) {
      return false;
    }
    ManagementBattery managementBattery = (ManagementBattery) o;
    return Objects.equals(id, managementBattery.id) && Objects.equals(provider, managementBattery.provider)
        && Objects.equals(battery, managementBattery.battery) && Objects.equals(moment, managementBattery.moment)
        && Objects.equals(amount, managementBattery.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, provider, battery, moment, amount);
  }

  @Override
  public String toString() {
    return "{" + " id='" + getId() + "'" + ", provider='" + getProvider() + "'" + ", battery='" + getBattery() + "'"
        + ", moment='" + getMoment() + "'" + ", amount='" + getAmount() + "'" + "}";
  }

}
