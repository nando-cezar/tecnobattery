package com.tecnobattery.tbsystem.dto.request;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ManagementLoaderRequest implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long providerId;
    private Long loaderId;
    private Integer amount;

}
