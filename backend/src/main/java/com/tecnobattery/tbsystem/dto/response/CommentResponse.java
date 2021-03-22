package com.tecnobattery.tbsystem.dto.response;

import java.io.Serializable;
import java.time.OffsetDateTime;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class CommentResponse implements Serializable {

  /** 
   *
   */
  private static final long serialVersionUID = 1L;
  private Long id;
  private String title;
  private String description;
  private OffsetDateTime moment;

}
