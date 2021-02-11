package com.tecnobattery.tbsystem.dto;

import java.time.OffsetDateTime;
import java.util.Objects;

public class ManagementLoaderDTO {

  private Long id;
  private ProviderDTO provider;
  private LoaderDTO loader;
  private OffsetDateTime moment;
  private Integer amount;

  public ManagementLoaderDTO() {
  }

  public ManagementLoaderDTO(Long id, ProviderDTO provider, LoaderDTO loader, OffsetDateTime moment, Integer amount) {
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

  public ProviderDTO getProvider() {
    return this.provider;
  }

  public void setProvider(ProviderDTO provider) {
    this.provider = provider;
  }

  public LoaderDTO getLoader() {
    return this.loader;
  }

  public void setLoader(LoaderDTO loader) {
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
    if (!(o instanceof ManagementLoaderDTO)) {
      return false;
    }
    ManagementLoaderDTO managementLoaderDTO = (ManagementLoaderDTO) o;
    return Objects.equals(id, managementLoaderDTO.id) && Objects.equals(provider, managementLoaderDTO.provider)
        && Objects.equals(loader, managementLoaderDTO.loader) && Objects.equals(moment, managementLoaderDTO.moment)
        && Objects.equals(amount, managementLoaderDTO.amount);
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
