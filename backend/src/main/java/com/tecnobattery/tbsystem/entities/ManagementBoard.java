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
@Table(name = "tb_management_board")
public class ManagementBoard implements Serializable {

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
  private Board board;
  private OffsetDateTime moment;
  private Integer amount;

  public ManagementBoard(Provider provider, Board board, OffsetDateTime moment, Integer amount) {
    this.provider = provider;
    this.board = board;
    this.moment = moment;
    this.amount = amount;
  }

}
