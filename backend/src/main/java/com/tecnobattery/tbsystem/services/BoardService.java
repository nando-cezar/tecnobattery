package com.tecnobattery.tbsystem.services;

import java.util.List;
import java.util.Optional;

import com.tecnobattery.tbsystem.dto.output.BoardOutput;
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

  public BoardOutput save(Board board) {

    Board boardExists = boardRepository.findByModel(board.getModel());

    if (boardExists != null && boardExists.equals(board)) {
      throw new BusinessException("Já existe uma placa cadastrada com este modelo.");
    }
    return toolModelMapper.toModel(boardRepository.save(board), BoardOutput.class);
  }

  @Transactional(readOnly = true)
  public List<BoardOutput> findAll() {
    List<Board> boards = boardRepository.findAll();
    return toolModelMapper.toCollection(boards, BoardOutput.class);
  }

  @Transactional(readOnly = true)
  public BoardOutput findById(Long boardId) {
    Optional<Board> board = boardRepository.findById(boardId);
    if (board.isPresent()) {
      return toolModelMapper.toModel(board.get(), BoardOutput.class);
    }
    return toolModelMapper.toModel(board.orElseThrow(() -> new BusinessException("Board: não encontrada.")), BoardOutput.class);
  }

  @Transactional(readOnly = true)
  public boolean existsById(Long boardId) {
    return boardRepository.existsById(boardId);
  }

  public void deleteById(Long boardId) {
    boardRepository.deleteById(boardId);
  }
}
