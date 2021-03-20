package com.tecnobattery.tbsystem.auth.service;

import java.util.List;
import java.util.Optional;

import com.tecnobattery.tbsystem.auth.model.User;
import com.tecnobattery.tbsystem.auth.repository.UserRepository;
import com.tecnobattery.tbsystem.dto.response.UserResponse;
import com.tecnobattery.tbsystem.exception.BusinessException;
import com.tecnobattery.tbsystem.tools.ToolModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private ToolModelMapper toolModelMapper;

  public UserResponse save(User user, boolean identifier) {

    if (!identifier) {

      User userExists = userRepository.findByEmail(user.getEmail());

      if (userExists != null && !userExists.equals(user)) {
        throw new BusinessException("Já existe um usuário cadastrado com este e-mail.");
      }
    }
    return toolModelMapper.toModel(userRepository.save(user), UserResponse.class);
  }

  @Transactional(readOnly = true)
  public List<UserResponse> findAll() {
    List<User> users = userRepository.findAll();
    return toolModelMapper.toCollection(users, UserResponse.class);
  }

  @Transactional(readOnly = true)
  public UserResponse findById(Long userId) {
    Optional<User> user = userRepository.findById(userId);
    if (user.isPresent()) {
      return toolModelMapper.toModel(user.get(), UserResponse.class);
    }
    return toolModelMapper.toModel(user.orElseThrow(() -> new BusinessException("User: não encontrada.")),
        UserResponse.class);
  }

  @Transactional(readOnly = true)
  public boolean existsById(Long userId) {
    return userRepository.existsById(userId);
  }

  public void deleteById(Long userId) {
    userRepository.deleteById(userId);
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException(String.format("Username %s not found", username)));
  }

}
