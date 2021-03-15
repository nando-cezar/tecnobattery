package com.tecnobattery.tbsystem.dto.request;

import java.io.Serializable;

public class ManagementBatteryRequest implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long providerId;
    private Long batteryId;
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

    public Long getBatteryId() {
        return this.batteryId;
    }

    public void setBatteryId(Long batteryId) {
        this.batteryId = batteryId;
    }

    public Integer getAmount() {
        return this.amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

}
