package com.photoshoot.snapbooking.controller;

import com.photoshoot.snapbooking.entity.Portfolio;
import com.photoshoot.snapbooking.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/portfolios")
public class PortfolioController {

  @Autowired
  private PortfolioService portfolioService;

  @PostMapping
  public Portfolio createPortfolio(@RequestBody Portfolio portfolio) {
    return portfolioService.savePortfolio(portfolio);
  }

  @GetMapping("/photographer/{photographerId}")
  public List<Portfolio> getPortfoliosByPhotographerId(@PathVariable Long photographerId) {
    return portfolioService.getPortfoliosByPhotographerId(photographerId);
  }
}

