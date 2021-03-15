package com.tecnobattery.tbsystem.dto.response;

import java.io.Serializable;
import java.time.OffsetDateTime;

public class ManagementBoardResponse implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private Long id;
  private ProviderResponse provider;
  private BoardResponse board;
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

  public BoardResponse getBoard() {
    return this.board;
  }

  public void setBoard(BoardResponse board) {
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
}
