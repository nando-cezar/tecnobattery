package com.tecnobattery.tbsystem.services;

import java.util.List;
import java.util.Optional;

import com.tecnobattery.tbsystem.dto.response.StockResponse;
import com.tecnobattery.tbsystem.entities.Stock;
import com.tecnobattery.tbsystem.error.exception.BusinessException;
import com.tecnobattery.tbsystem.repositories.StockRepository;
import com.tecnobattery.tbsystem.tools.ToolModelMapper;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StockService {

  private final StockRepository stockRepository;
  private final ToolModelMapper toolModelMapper;

  public StockResponse save(Stock stock) {
    return toolModelMapper.toModel(stockRepository.save(stock), StockResponse.class);
  }

  public List<StockResponse> findAll() {
    return toolModelMapper.toCollection(stockRepository.findAll(), StockResponse.class);
  }

  public StockResponse findById(Long stockId) {
    Optional<Stock> stock = stockRepository.findById(stockId);
    if (stock.isPresent()) {
      return toolModelMapper.toModel(stock.get(), StockResponse.class);
    }
    return toolModelMapper.toModel(stock.orElseThrow(() -> new BusinessException("Stock: não encontrada.")),
        StockResponse.class);
  }

  public boolean existsById(Long stockId) {
    return stockRepository.existsById(stockId);
  }

  public void deleteById(Long stockId) {
    stockRepository.deleteById(stockId);
  }
}
