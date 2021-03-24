package com.tecnobattery.tbsystem.services;

import java.util.List;
import java.util.Optional;

import com.tecnobattery.tbsystem.dto.response.BoardResponse;
import com.tecnobattery.tbsystem.entities.Board;
import com.tecnobattery.tbsystem.error.exception.BusinessException;
import com.tecnobattery.tbsystem.repositories.BoardRepository;
import com.tecnobattery.tbsystem.tools.ToolModelMapper;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BoardService {

  private final BoardRepository boardRepository;
  private final ToolModelMapper toolModelMapper;

  public BoardResponse save(Board board, boolean identifier) {

    if (!identifier) {

      Board boardExists = boardRepository.findByModel(board.getModel());

      if (boardExists != null && !boardExists.equals(board)) {
        throw new BusinessException("Já existe uma placa cadastrada com este modelo.");
      }
    }
    return toolModelMapper.toModel(boardRepository.save(board), BoardResponse.class);
  }

  public List<BoardResponse> findAll() {
    return toolModelMapper.toCollection(boardRepository.findAll(), BoardResponse.class);
  }

  public BoardResponse findById(Long boardId) {
    Optional<Board> board = boardRepository.findById(boardId);
    if (board.isPresent()) {
      return toolModelMapper.toModel(board.get(), BoardResponse.class);
    }
    return toolModelMapper.toModel(board.orElseThrow(() -> new BusinessException("Board: não encontrada.")),
        BoardResponse.class);
  }

  public boolean existsById(Long boardId) {
    return boardRepository.existsById(boardId);
  }

  public void deleteById(Long boardId) {
    boardRepository.deleteById(boardId);
  }
}
