package com.tecnobattery.tbsystem.services;

import java.util.List;
import java.util.Optional;

import com.tecnobattery.tbsystem.dto.output.UserOutput;
import com.tecnobattery.tbsystem.entities.User;
import com.tecnobattery.tbsystem.exception.BusinessException;
import com.tecnobattery.tbsystem.repositories.UserRepository;
import com.tecnobattery.tbsystem.tools.ToolModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private ToolModelMapper toolModelMapper;

  public UserOutput save(User user, boolean identifier) {

    if (!identifier) {

      User userExists = userRepository.findByEmail(user.getEmail());

      if (userExists != null && !userExists.equals(user)) {
        throw new BusinessException("Já existe um usuário cadastrado com este e-mail.");
      }
    }
    return toolModelMapper.toModel(userRepository.save(user), UserOutput.class);
  }

  @Transactional(readOnly = true)
  public List<UserOutput> findAll() {
    List<User> users = userRepository.findAll();
    return toolModelMapper.toCollection(users, UserOutput.class);
  }

  @Transactional(readOnly = true)
  public UserOutput findById(Long userId) {
    Optional<User> user = userRepository.findById(userId);
    if (user.isPresent()) {
      return toolModelMapper.toModel(user.get(), UserOutput.class);
    }
    return toolModelMapper.toModel(user.orElseThrow(() -> new BusinessException("User: não encontrada.")),
        UserOutput.class);
  }

  @Transactional(readOnly = true)
  public boolean existsById(Long userId) {
    return userRepository.existsById(userId);
  }

  public void deleteById(Long userId) {
    userRepository.deleteById(userId);
  }

}
