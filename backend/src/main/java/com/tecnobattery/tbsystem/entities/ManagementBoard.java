package com.tecnobattery.tbsystem.entities;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
  @ManyToOne
  private Board board;
  private OffsetDateTime moment;
  private Integer amount;

  public ManagementBoard() {
  }

  public ManagementBoard(Long id, Provider provider, Board board, OffsetDateTime moment, Integer amount) {
    this.id = id;
    this.provider = provider;
    this.board = board;
    this.moment = moment;
    this.amount = amount;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Provider getProvider() {
    return this.provider;
  }

  public void setProvider(Provider provider) {
    this.provider = provider;
  }

  public Board getBoard() {
    return this.board;
  }

  public void setBoard(Board board) {
    this.board = board;
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
    if (!(o instanceof ManagementBoard)) {
      return false;
    }
    ManagementBoard managementBoard = (ManagementBoard) o;
    return Objects.equals(id, managementBoard.id) && Objects.equals(provider, managementBoard.provider)
        && Objects.equals(board, managementBoard.board) && Objects.equals(moment, managementBoard.moment)
        && Objects.equals(amount, managementBoard.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, provider, board, moment, amount);
  }

  @Override
  public String toString() {
    return "{" + " id='" + getId() + "'" + ", provider='" + getProvider() + "'" + ", board='" + getBoard() + "'"
        + ", moment='" + getMoment() + "'" + ", amount='" + getAmount() + "'" + "}";
  }

}
