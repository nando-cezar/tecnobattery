package com.tecnobattery.tbsystem.services;

import java.util.List;
import java.util.Optional;

import com.tecnobattery.tbsystem.dto.response.ManagementBoardResponse;
import com.tecnobattery.tbsystem.entities.ManagementBoard;
import com.tecnobattery.tbsystem.error.exception.BusinessException;
import com.tecnobattery.tbsystem.repositories.ManagementBoardRepository;
import com.tecnobattery.tbsystem.tools.ToolModelMapper;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ManagementBoardService {

  private final ManagementBoardRepository managementBoardRepository;
  private final ToolModelMapper toolModelMapper;

  public ManagementBoardResponse save(ManagementBoard managementBoard) {
    return toolModelMapper.toModel(managementBoardRepository.save(managementBoard), ManagementBoardResponse.class);
  }

  public List<ManagementBoardResponse> findAll() {
    return toolModelMapper.toCollection(managementBoardRepository.findAll(), ManagementBoardResponse.class);
  }

  public ManagementBoardResponse findById(Long managementBoardId) {
    Optional<ManagementBoard> managementBoard = managementBoardRepository.findById(managementBoardId);
    if (managementBoard.isPresent()) {
      return toolModelMapper.toModel(managementBoard.get(), ManagementBoardResponse.class);
    }
    return toolModelMapper.toModel(
        managementBoard.orElseThrow(() -> new BusinessException("ManagementBoard: não encontrada.")),
        ManagementBoardResponse.class);
  }

  public boolean existsById(Long managementBoardId) {
    return managementBoardRepository.existsById(managementBoardId);
  }

  public void deleteById(Long managementBoardId) {
    managementBoardRepository.deleteById(managementBoardId);
  }
}
