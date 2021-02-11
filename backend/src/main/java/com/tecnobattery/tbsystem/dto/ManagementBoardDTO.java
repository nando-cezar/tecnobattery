package com.tecnobattery.tbsystem.dto;

import java.time.OffsetDateTime;
import java.util.Objects;

public class ManagementBoardDTO {

  private Long id;
  private ProviderDTO provider;
  private BoardDTO board;
  private OffsetDateTime moment;
  private Integer amount;

  public ManagementBoardDTO() {
  }

  public ManagementBoardDTO(Long id, ProviderDTO provider, BoardDTO board, OffsetDateTime moment, Integer amount) {
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

  public ProviderDTO getProvider() {
    return this.provider;
  }

  public void setProvider(ProviderDTO provider) {
    this.provider = provider;
  }

  public BoardDTO getBoard() {
    return this.board;
  }

  public void setBoard(BoardDTO board) {
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
    if (!(o instanceof ManagementBoardDTO)) {
      return false;
    }
    ManagementBoardDTO managementBoardDTO = (ManagementBoardDTO) o;
    return Objects.equals(id, managementBoardDTO.id) && Objects.equals(provider, managementBoardDTO.provider)
        && Objects.equals(board, managementBoardDTO.board) && Objects.equals(moment, managementBoardDTO.moment)
        && Objects.equals(amount, managementBoardDTO.amount);
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
