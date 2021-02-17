package com.tecnobattery.tbsystem.services;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.tecnobattery.tbsystem.dto.ManagementBoardDTO;
import com.tecnobattery.tbsystem.entities.Board;
import com.tecnobattery.tbsystem.entities.ManagementBoard;
import com.tecnobattery.tbsystem.entities.Provider;
import com.tecnobattery.tbsystem.repositories.BoardRepository;
import com.tecnobattery.tbsystem.repositories.ManagementBoardRepository;
import com.tecnobattery.tbsystem.repositories.ProviderRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ManagementBoardService {

  @Autowired
  private ManagementBoardRepository managementBoardRepository;

  @Autowired
  private ProviderRepository providerRepository;

  @Autowired
  private BoardRepository boardRepository;

  @Autowired
  private ModelMapper mapper;

  public ManagementBoardDTO save(Long providerId, Long boardId, OffsetDateTime moment, Integer amount)
      throws Exception {
    Provider provider = providerRepository.findById(providerId).orElseThrow(() -> new Exception("Provider: not found"));
    Board board = boardRepository.findById(boardId).orElseThrow(() -> new Exception("Board: not found"));
    ManagementBoard managementBoard = new ManagementBoard();
    managementBoard.setProvider(provider);
    managementBoard.setBoard(board);
    managementBoard.setMoment(moment);
    managementBoard.setAmount(amount);

    return toModel(managementBoardRepository.save(managementBoard));
  }

  @Transactional(readOnly = true)
  public List<ManagementBoardDTO> findAll() {
    List<ManagementBoard> boards = managementBoardRepository.findAll();
    return toCollectionDTO(boards);
  }

  private ManagementBoardDTO toModel(ManagementBoard managementBoard) {
    return mapper.map(managementBoard, ManagementBoardDTO.class);
  }

  private List<ManagementBoardDTO> toCollectionDTO(List<ManagementBoard> boards) {
    return boards.stream().map(x -> toModel(x)).collect(Collectors.toList());
  }
}
