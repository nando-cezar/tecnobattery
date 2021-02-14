package com.tecnobattery.tbsystem.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String username;
  private String email;
  private String phone;
  private String password;
  private TypeUser level;

  public User() {
  }

  public User(Long id, String username, String email, String phone, String password, TypeUser level) {
    this.id = id;
    this.username = username;
    this.email = email;
    this.phone = phone;
    this.password = password;
    this.level = level;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return this.phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public TypeUser getLevel() {
    return this.level;
  }

  public void setLevel(TypeUser level) {
    this.level = level;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof User)) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(id, user.id) && Objects.equals(username, user.username) && Objects.equals(email, user.email)
        && Objects.equals(phone, user.phone) && Objects.equals(password, user.password)
        && Objects.equals(level, user.level);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, username, email, phone, password, level);
  }

  @Override
  public String toString() {
    return "{" + " id='" + getId() + "'" + ", username='" + getUsername() + "'" + ", email='" + getEmail() + "'"
        + ", phone='" + getPhone() + "'" + ", password='" + getPassword() + "'" + ", level='" + getLevel() + "'" + "'"
        + "'" + "}";
  }

}
