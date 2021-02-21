package com.tecnobattery.tbsystem.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.tecnobattery.tbsystem.dto.BoardDTO;
import com.tecnobattery.tbsystem.entities.Board;
import com.tecnobattery.tbsystem.exception.BusinessException;
import com.tecnobattery.tbsystem.repositories.BoardRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardService {

  @Autowired
  private BoardRepository boardRepository;

  @Autowired
  private ModelMapper mapper;

  public BoardDTO save(Board board) {

    Board boardExists = boardRepository.findByModel(board.getModel());

    if (boardExists != null && !boardExists.equals(board)) {
      throw new BusinessException("Já existe uma placa cadastrada com este modelo.");
    }
    return toModel(boardRepository.save(board));
  }

  @Transactional(readOnly = true)
  public List<BoardDTO> findAll() {
    List<Board> boards = boardRepository.findAll();
    return toCollectionDTO(boards);
  }

  @Transactional(readOnly = true)
  public BoardDTO findById(Long boardId) {
    Optional<Board> board = boardRepository.findById(boardId);
    if (board.isPresent()) {
      return toModel(board.get());
    }
    return null;
  }

  @Transactional(readOnly = true)
  public boolean existsById(Long boardId) {
    return boardRepository.existsById(boardId);
  }

  public void deleteById(Long boardId) {
    boardRepository.deleteById(boardId);
  }

  private BoardDTO toModel(Board board) {
    return mapper.map(board, BoardDTO.class);
  }

  private List<BoardDTO> toCollectionDTO(List<Board> boards) {
    return boards.stream().map(x -> toModel(x)).collect(Collectors.toList());
  }
}
