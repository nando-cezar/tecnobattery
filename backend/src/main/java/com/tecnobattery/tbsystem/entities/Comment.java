package com.tecnobattery.tbsystem.entities;

import java.io.Serializable;
import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.tecnobattery.tbsystem.auth.model.User;

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
@Table(name = "tb_comment")
public class Comment implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne
  private Order order;
  @ManyToOne
  private User user;
  private String title;
  private String description;
  private OffsetDateTime moment;

  public Comment(Order order, User user, String title, String description, OffsetDateTime moment) {
    this.order = order;
    this.user = user;
    this.title = title;
    this.description = description;
    this.moment = moment;
  }

}
