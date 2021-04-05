package com.tecnobattery.tbsystem.controllers.management;

import java.util.List;

import javax.validation.Valid;

import com.tecnobattery.tbsystem.dto.request.FeedstockRequest;
import com.tecnobattery.tbsystem.dto.response.FeedstockResponse;
import com.tecnobattery.tbsystem.entities.Feedstock;
import com.tecnobattery.tbsystem.services.FeedstockService;
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
@RequestMapping(value = "/management/api/v1/feedstocks")
@AllArgsConstructor
public class FeedstockManagementController {

  private final FeedstockService feedstockService;
  private final ToolModelMapper toolModelMapper;

  @PostMapping
  @PreAuthorize("hasAuthority('global:write')")
  @ResponseStatus(HttpStatus.CREATED)
  public FeedstockResponse save(@Valid @RequestBody FeedstockRequest feedstockInput) {
    return feedstockService.save(toolModelMapper.toModel(feedstockInput, Feedstock.class), false);
  }

  @GetMapping
  @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
  public ResponseEntity<List<FeedstockResponse>> findAll() {
    return ResponseEntity.ok().body(feedstockService.findAll());
  }

  @GetMapping("/{feedstockId}")
  @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
  public ResponseEntity<FeedstockResponse> findById(@PathVariable Long feedstockId) {
    return ResponseEntity.ok(feedstockService.findById(feedstockId));
  }

  @PutMapping("/{feedstockId}")
  @PreAuthorize("hasAuthority('global:write')")
  public ResponseEntity<FeedstockResponse> update(@PathVariable Long feedstockId,
      @Valid @RequestBody FeedstockRequest feedstockInput) {

    if (!feedstockService.existsById(feedstockId)) {
      return ResponseEntity.notFound().build();
    }

    Feedstock feedstock = new Feedstock();
    feedstock = toolModelMapper.toModel(feedstockInput, Feedstock.class);
    feedstock.setId(feedstockId);

    return ResponseEntity.ok(feedstockService.save(feedstock, true));
  }

  @DeleteMapping("/{feedstockId}")
  @PreAuthorize("hasAuthority('global:write')")
  public ResponseEntity<Void> deleteById(@PathVariable Long feedstockId) {
    if (!feedstockService.existsById(feedstockId)) {
      return ResponseEntity.notFound().build();
    }
    feedstockService.deleteById(feedstockId);
    return ResponseEntity.noContent().build();
  }
}
