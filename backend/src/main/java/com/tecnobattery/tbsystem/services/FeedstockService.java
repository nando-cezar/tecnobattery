package com.tecnobattery.tbsystem.services;

import java.util.List;
import java.util.Optional;

import com.tecnobattery.tbsystem.dto.response.FeedstockResponse;
import com.tecnobattery.tbsystem.entities.Feedstock;
import com.tecnobattery.tbsystem.error.exception.BusinessException;
import com.tecnobattery.tbsystem.repositories.FeedstockRepository;
import com.tecnobattery.tbsystem.tools.ToolModelMapper;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FeedstockService {

  private final FeedstockRepository feedstockRepository;
  private final ToolModelMapper toolModelMapper;

  public FeedstockResponse save(Feedstock feedstock, boolean identifier) {

    if (!identifier) {

      Feedstock feedstockExists = feedstockRepository.findByModel(feedstock.getModel());

      if (feedstockExists != null && !feedstockExists.equals(feedstock)) {
        throw new BusinessException("Já existe uma placa cadastrada com este modelo.");
      }
    }
    return toolModelMapper.toModel(feedstockRepository.save(feedstock), FeedstockResponse.class);
  }

  public List<FeedstockResponse> findAll() {
    return toolModelMapper.toCollection(feedstockRepository.findAll(), FeedstockResponse.class);
  }

  public FeedstockResponse findById(Long FeedstockId) {
    Optional<Feedstock> feedstock = feedstockRepository.findById(FeedstockId);
    if (feedstock.isPresent()) {
      return toolModelMapper.toModel(feedstock.get(), FeedstockResponse.class);
    }
    return toolModelMapper.toModel(feedstock.orElseThrow(() -> new BusinessException("Feedstock: não encontrada.")),
        FeedstockResponse.class);
  }

  public boolean existsById(Long feedstockId) {
    return feedstockRepository.existsById(feedstockId);
  }

  public void deleteById(Long feedstockId) {
    feedstockRepository.deleteById(feedstockId);
  }
}
