package com.tecnobattery.tbsystem.services;

import java.util.List;
import java.util.stream.Collectors;

import com.tecnobattery.tbsystem.dto.BoardDTO;
import com.tecnobattery.tbsystem.entities.Board;
import com.tecnobattery.tbsystem.repositories.BoardRepository;

import org.hibernate.collection.spi.PersistentCollection;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

  @Autowired
  private BoardRepository boardRepository;

  @Autowired
  private ModelMapper mapper;

  public List<BoardDTO> findAll() {
    List<Board> batterys = boardRepository.findAll();
    return toCollectionDTO(batterys);
  }

  private BoardDTO toModel(Board board) {
    mapper.getConfiguration().setPropertyCondition(context -> !(context.getSource() instanceof PersistentCollection));
    return mapper.map(board, BoardDTO.class);
  }

  private List<BoardDTO> toCollectionDTO(List<Board> boards) {
    return boards.stream().map(x -> toModel(x)).collect(Collectors.toList());
  }
}
