package com.tecnobattery.tbsystem.controllers.management;

import java.time.OffsetDateTime;
import java.util.List;

import javax.validation.Valid;

import com.tecnobattery.tbsystem.dto.request.StockRequest;
import com.tecnobattery.tbsystem.dto.response.StockResponse;
import com.tecnobattery.tbsystem.entities.Feedstock;
import com.tecnobattery.tbsystem.entities.Provider;
import com.tecnobattery.tbsystem.entities.Stock;
import com.tecnobattery.tbsystem.services.FeedstockService;
import com.tecnobattery.tbsystem.services.ProviderService;
import com.tecnobattery.tbsystem.services.StockService;
import com.tecnobattery.tbsystem.tools.ToolModelMapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/management/api/v1/stocks")
@AllArgsConstructor
public class StockManagementController {

  private final StockService stockService;
  private final FeedstockService feedstockService;
  private final ProviderService providerService;
  private final ToolModelMapper toolModelMapper;

  @PostMapping
  @PreAuthorize("hasAuthority('global:write')")
  @ResponseStatus(HttpStatus.CREATED)
  public StockResponse save(@Valid @RequestBody StockRequest stockInput) {

    Stock stock = toolModelMapper.toModel(stockInput, Stock.class);
    stock
        .setFeedstock(toolModelMapper.toModel(feedstockService.findById(stockInput.getFeedstockId()), Feedstock.class));
    stock.setProvider(toolModelMapper.toModel(providerService.findById(stockInput.getProviderId()), Provider.class));
    stock.setMoment(OffsetDateTime.now());

    return stockService.save(stock);
  }

  @GetMapping
  @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
  public ResponseEntity<List<StockResponse>> findAll() {
    return ResponseEntity.ok().body(stockService.findAll());
  }

  @GetMapping("/{stockId}")
  @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
  public ResponseEntity<StockResponse> findById(@PathVariable Long stockId) {
    return ResponseEntity.ok(stockService.findById(stockId));
  }

  @PutMapping("/{stockId}")
  @PreAuthorize("hasAuthority('global:write')")
  public ResponseEntity<StockResponse> update(@PathVariable Long stockId, @Valid @RequestBody StockRequest stockInput) {

    if (!stockService.existsById(stockId)) {
      return ResponseEntity.notFound().build();
    }

    Stock stock = toolModelMapper.toModel(stockService.findById(stockId), Stock.class);
    stock
        .setFeedstock(toolModelMapper.toModel(feedstockService.findById(stockInput.getFeedstockId()), Feedstock.class));
    stock.setProvider(toolModelMapper.toModel(providerService.findById(stockInput.getProviderId()), Provider.class));
    stock.setAmount(stockInput.getAmount());
    stock.setId(stockId);

    return ResponseEntity.ok(stockService.save(stock));
  }

  @DeleteMapping("/{stockId}")
  @PreAuthorize("hasAuthority('global:write')")
  public ResponseEntity<Void> deleteById(@PathVariable Long stockId) {
    if (!stockService.existsById(stockId)) {
      return ResponseEntity.notFound().build();
    }
    stockService.deleteById(stockId);
    return ResponseEntity.noContent().build();
  }
}
