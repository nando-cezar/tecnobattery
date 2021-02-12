package com.tecnobattery.tbsystem.dto;

import java.io.Serializable;
import java.time.OffsetDateTime;

public class ManagementBatteryDTO implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private Long id;
  private ProviderDTO provider;
  private BatteryDTO battery;
  private OffsetDateTime moment;
  private Integer amount;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public ProviderDTO getProvider() {
    return this.provider;
  }

  public void setProvider(ProviderDTO provider) {
    this.provider = provider;
  }

  public BatteryDTO getBattery() {
    return this.battery;
  }

  public void setBattery(BatteryDTO battery) {
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

}
