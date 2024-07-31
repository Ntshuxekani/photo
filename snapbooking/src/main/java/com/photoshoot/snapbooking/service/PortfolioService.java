package com.photoshoot.snapbooking.service;

import com.photoshoot.snapbooking.entity.Portfolio;
import com.photoshoot.snapbooking.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioService {

  @Autowired
  private PortfolioRepository portfolioRepository;

  public Portfolio savePortfolio(Portfolio portfolio) {
    return portfolioRepository.save(portfolio);
  }

  public List<Portfolio> getPortfoliosByPhotographerId(Long photographerId) {
    return portfolioRepository.findByPhotographerId(photographerId);
  }
}

