package com.tecnobattery.tbsystem.dto.output;

import java.io.Serializable;
import java.time.OffsetDateTime;

public class ManagementBatteryOutput implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private Long id;
  private ProviderOutput provider;
  private BatteryOutput battery;
  private OffsetDateTime moment;
  private Integer amount;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public ProviderOutput getProvider() {
    return this.provider;
  }

  public void setProvider(ProviderOutput provider) {
    this.provider = provider;
  }

  public BatteryOutput getBattery() {
    return this.battery;
  }

  public void setBattery(BatteryOutput battery) {
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
