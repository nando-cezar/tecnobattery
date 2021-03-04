package com.tecnobattery.tbsystem.services;

import java.util.List;
import java.util.Optional;

import com.tecnobattery.tbsystem.dto.output.ManagementBoardOutput;
import com.tecnobattery.tbsystem.entities.ManagementBoard;
import com.tecnobattery.tbsystem.exception.BusinessException;
import com.tecnobattery.tbsystem.repositories.ManagementBoardRepository;
import com.tecnobattery.tbsystem.tools.ToolModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ManagementBoardService {

  @Autowired
  private ManagementBoardRepository managementBoardRepository;

  @Autowired
  private ToolModelMapper toolModelMapper;

  public ManagementBoardOutput save(ManagementBoard managementBoard) {
    return toolModelMapper.toModel(managementBoardRepository.save(managementBoard), ManagementBoardOutput.class);
  }

  @Transactional(readOnly = true)
  public List<ManagementBoardOutput> findAll() {
    List<ManagementBoard> boards = managementBoardRepository.findAll();
    return toolModelMapper.toCollection(boards, ManagementBoardOutput.class);
  }

  @Transactional(readOnly = true)
  public ManagementBoardOutput findById(Long managementBoardId) {
    Optional<ManagementBoard> managementBoard = managementBoardRepository.findById(managementBoardId);
    if (managementBoard.isPresent()) {
      return toolModelMapper.toModel(managementBoard.get(), ManagementBoardOutput.class);
    }
    return toolModelMapper.toModel(
        managementBoard.orElseThrow(() -> new BusinessException("ManagementBoard: não encontrada.")),
        ManagementBoardOutput.class);
  }

  @Transactional(readOnly = true)
  public boolean existsById(Long managementBoardId) {
    return managementBoardRepository.existsById(managementBoardId);
  }

  public void deleteById(Long managementBoardId) {
    managementBoardRepository.deleteById(managementBoardId);
  }
}
