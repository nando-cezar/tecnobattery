package com.tecnobattery.tbsystem.dto.response;

import java.io.Serializable;
import java.time.OffsetDateTime;

public class ManagementLoaderResponse implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private Long id;
  private ProviderResponse provider;
  private LoaderResponse loader;
  private OffsetDateTime moment;
  private Integer amount;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public ProviderResponse getProvider() {
    return this.provider;
  }

  public void setProvider(ProviderResponse provider) {
    this.provider = provider;
  }

  public LoaderResponse getLoader() {
    return this.loader;
  }

  public void setLoader(LoaderResponse loader) {
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
}
