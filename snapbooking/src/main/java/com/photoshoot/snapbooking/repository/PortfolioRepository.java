package com.photoshoot.snapbooking.repository;


import com.photoshoot.snapbooking.entity.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
  List<Portfolio> findByPhotographerId(Long photographerId);
}

