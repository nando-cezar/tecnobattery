package com.tecnobattery.tbsystem.auth.service;

import java.util.List;
import java.util.Optional;

import com.tecnobattery.tbsystem.auth.model.User;
import com.tecnobattery.tbsystem.auth.repository.UserRepository;
import com.tecnobattery.tbsystem.dto.response.UserResponse;
import com.tecnobattery.tbsystem.error.exception.BusinessException;
import com.tecnobattery.tbsystem.tools.ToolModelMapper;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

  private final UserRepository userRepository;
  private final ToolModelMapper toolModelMapper;

  public UserResponse save(User user, boolean identifier) {

    if (!identifier) {

      User userExists = userRepository.findByEmail(user.getEmail());

      if (userExists != null && !userExists.equals(user)) {
        throw new BusinessException("Já existe um usuário cadastrado com este e-mail.");
      }
    }
    return toolModelMapper.toModel(userRepository.save(user), UserResponse.class);
  }

  public List<UserResponse> findAll() {
    return toolModelMapper.toCollection(userRepository.findAll(), UserResponse.class);
  }

  public UserResponse findById(Long userId) {
    Optional<User> user = userRepository.findById(userId);
    if (user.isPresent()) {
      return toolModelMapper.toModel(user.get(), UserResponse.class);
    }
    return toolModelMapper.toModel(user.orElseThrow(() -> new BusinessException("User: não encontrada.")),
        UserResponse.class);
  }

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
