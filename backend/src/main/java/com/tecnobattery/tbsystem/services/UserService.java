package com.tecnobattery.tbsystem.services;

import java.util.List;
import java.util.stream.Collectors;

import com.tecnobattery.tbsystem.dto.UserDTO;
import com.tecnobattery.tbsystem.entities.TypeUser;
import com.tecnobattery.tbsystem.entities.User;
import com.tecnobattery.tbsystem.repositories.UserRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private ModelMapper mapper;

  public UserDTO save(String username, String email, String phone, String password, TypeUser level) {
    User user = new User();
    user.setUsername(username);
    user.setEmail(email);
    user.setPhone(phone);
    user.setPassword(password);
    user.setLevel(level);

    return toModel(userRepository.save(user));
  }

  @Transactional(readOnly = true)
  public List<UserDTO> findAll() {
    List<User> users = userRepository.findAll();
    return toCollectionDTO(users);
  }

  private UserDTO toModel(User user) {
    return mapper.map(user, UserDTO.class);
  }

  private List<UserDTO> toCollectionDTO(List<User> users) {
    return users.stream().map(x -> toModel(x)).collect(Collectors.toList());
  }
}
