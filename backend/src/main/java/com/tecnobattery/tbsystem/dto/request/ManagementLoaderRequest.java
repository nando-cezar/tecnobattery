package com.tecnobattery.tbsystem.dto.request;

import java.io.Serializable;

public class ManagementLoaderRequest implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long providerId;
    private Long loaderId;
    private Integer amount;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProviderId() {
        return this.providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

    public Long getLoaderId() {
        return this.loaderId;
    }

    public void setLoaderId(Long loaderId) {
        this.loaderId = loaderId;
    }

    public Integer getAmount() {
        return this.amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

}
