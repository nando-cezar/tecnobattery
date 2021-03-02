package com.tecnobattery.tbsystem.controllers;

import java.util.List;

import javax.validation.Valid;

import com.tecnobattery.tbsystem.dto.input.UserInput;
import com.tecnobattery.tbsystem.dto.output.UserOutput;
import com.tecnobattery.tbsystem.entities.TypeUser;
import com.tecnobattery.tbsystem.entities.User;
import com.tecnobattery.tbsystem.services.UserService;
import com.tecnobattery.tbsystem.tools.ToolModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

  @Autowired
  private UserService userService;

  @Autowired
  private ToolModelMapper toolModelMapper;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public UserOutput save(@Valid @RequestBody UserInput userInput) {
    User user = toolModelMapper.toModel(userInput, User.class);
    user.setLevel(TypeUser.ADMINISTRADOR);

    return userService.save(user);
  }

  @GetMapping
  public ResponseEntity<List<UserOutput>> findAll() {
    List<UserOutput> list = userService.findAll();
    return ResponseEntity.ok().body(list);
  }

  @GetMapping("/{userId}")
  public ResponseEntity<UserOutput> findById(@PathVariable Long userId) {
    return ResponseEntity.ok(userService.findById(userId));
  }

  @PutMapping("/{userId}")
  public ResponseEntity<UserOutput> update(@Valid @PathVariable Long userId, @RequestBody UserInput userInput) {

    if (!userService.existsById(userId)) {
      return ResponseEntity.notFound().build();
    }

    User user = toolModelMapper.toModel(userInput, User.class);
    user.setId(userId);

    return ResponseEntity.ok(userService.save(user));
  }

  @DeleteMapping("/{userId}")
  public ResponseEntity<Void> deleteById(@PathVariable Long userId) {
    if (!userService.existsById(userId)) {
      return ResponseEntity.notFound().build();
    }
    userService.deleteById(userId);
    return ResponseEntity.noContent().build();
  }
}
