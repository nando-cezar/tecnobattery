package com.tecnobattery.tbsystem.services;

import java.util.List;
import java.util.stream.Collectors;

import com.tecnobattery.tbsystem.dto.ManagementBoardDTO;
import com.tecnobattery.tbsystem.entities.ManagementBoard;
import com.tecnobattery.tbsystem.repositories.ManagementBoardRepository;

import org.hibernate.collection.spi.PersistentCollection;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ManagementBoardService {

  @Autowired
  private ManagementBoardRepository boardRepository;

  @Autowired
  private ModelMapper mapper;

  @Transactional(readOnly = true)
  public List<ManagementBoardDTO> findAll() {
    List<ManagementBoard> boards = boardRepository.findAll();
    return toCollectionDTO(boards);
  }

  private ManagementBoardDTO toModel(ManagementBoard managementBoard) {
    mapper.getConfiguration().setPropertyCondition(context -> !(context.getSource() instanceof PersistentCollection));
    return mapper.map(managementBoard, ManagementBoardDTO.class);
  }

  private List<ManagementBoardDTO> toCollectionDTO(List<ManagementBoard> boards) {
    return boards.stream().map(x -> toModel(x)).collect(Collectors.toList());
  }
}
