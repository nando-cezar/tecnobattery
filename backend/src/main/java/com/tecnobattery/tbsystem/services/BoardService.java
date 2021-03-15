package com.tecnobattery.tbsystem.services;

import java.util.List;
import java.util.Optional;

import com.tecnobattery.tbsystem.dto.response.BoardResponse;
import com.tecnobattery.tbsystem.entities.Board;
import com.tecnobattery.tbsystem.exception.BusinessException;
import com.tecnobattery.tbsystem.repositories.BoardRepository;
import com.tecnobattery.tbsystem.tools.ToolModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardService {

  @Autowired
  private BoardRepository boardRepository;

  @Autowired
  private ToolModelMapper toolModelMapper;

  public BoardResponse save(Board board, boolean identifier) {

    if (!identifier) {

      Board boardExists = boardRepository.findByModel(board.getModel());

      if (boardExists != null && !boardExists.equals(board)) {
        throw new BusinessException("Já existe uma placa cadastrada com este modelo.");
      }
    }
    return toolModelMapper.toModel(boardRepository.save(board), BoardResponse.class);
  }

  @Transactional(readOnly = true)
  public List<BoardResponse> findAll() {
    List<Board> boards = boardRepository.findAll();
    return toolModelMapper.toCollection(boards, BoardResponse.class);
  }

  @Transactional(readOnly = true)
  public BoardResponse findById(Long boardId) {
    Optional<Board> board = boardRepository.findById(boardId);
    if (board.isPresent()) {
      return toolModelMapper.toModel(board.get(), BoardResponse.class);
    }
    return toolModelMapper.toModel(board.orElseThrow(() -> new BusinessException("Board: não encontrada.")),
        BoardResponse.class);
  }

  @Transactional(readOnly = true)
  public boolean existsById(Long boardId) {
    return boardRepository.existsById(boardId);
  }

  public void deleteById(Long boardId) {
    boardRepository.deleteById(boardId);
  }
}
