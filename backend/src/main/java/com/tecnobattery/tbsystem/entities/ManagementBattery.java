package com.tecnobattery.tbsystem.entities;

import java.io.Serializable;
import java.time.OffsetDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
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

  public ManagementBattery(Provider provider, Battery battery, OffsetDateTime moment, Integer amount) {
    this.provider = provider;
    this.battery = battery;
    this.moment = moment;
    this.amount = amount;
  }

}
