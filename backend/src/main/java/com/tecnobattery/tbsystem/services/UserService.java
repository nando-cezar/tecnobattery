package com.tecnobattery.tbsystem.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.tecnobattery.tbsystem.dto.output.UserOutput;
import com.tecnobattery.tbsystem.entities.User;
import com.tecnobattery.tbsystem.exception.BusinessException;
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

  public UserOutput save(User user) {

    User userExists = userRepository.findByEmail(user.getEmail());

    if (userExists != null && !userExists.equals(user)) {
      throw new BusinessException("Já existe um usuário cadastrado com este e-mail.");
    }
    return toModel(userRepository.save(user));
  }

  @Transactional(readOnly = true)
  public List<UserOutput> findAll() {
    List<User> users = userRepository.findAll();
    return toCollectionDTO(users);
  }

  @Transactional(readOnly = true)
  public UserOutput findById(Long userId) {
    Optional<User> user = userRepository.findById(userId);
    if (user.isPresent()) {
      return toModel(user.get());
    }
    return null;
  }

  @Transactional(readOnly = true)
  public boolean existsById(Long userId) {
    return userRepository.existsById(userId);
  }

  public void deleteById(Long userId) {
    userRepository.deleteById(userId);
  }

  private UserOutput toModel(User user) {
    return mapper.map(user, UserOutput.class);
  }

  private List<UserOutput> toCollectionDTO(List<User> users) {
    return users.stream().map(x -> toModel(x)).collect(Collectors.toList());
  }
}
