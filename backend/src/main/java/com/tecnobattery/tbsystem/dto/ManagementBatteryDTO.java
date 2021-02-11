package com.tecnobattery.tbsystem.dto;

import java.time.OffsetDateTime;
import java.util.Objects;

public class ManagementBatteryDTO {
  private Long id;
  private ProviderDTO provider;
  private BatteryDTO battery;
  private OffsetDateTime moment;
  private Integer amount;

  public ManagementBatteryDTO() {
  }

  public ManagementBatteryDTO(Long id, ProviderDTO provider, BatteryDTO battery, OffsetDateTime moment,
      Integer amount) {
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

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof ManagementBatteryDTO)) {
      return false;
    }
    ManagementBatteryDTO managementBatteryDTO = (ManagementBatteryDTO) o;
    return Objects.equals(id, managementBatteryDTO.id) && Objects.equals(provider, managementBatteryDTO.provider)
        && Objects.equals(battery, managementBatteryDTO.battery) && Objects.equals(moment, managementBatteryDTO.moment)
        && Objects.equals(amount, managementBatteryDTO.amount);
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
