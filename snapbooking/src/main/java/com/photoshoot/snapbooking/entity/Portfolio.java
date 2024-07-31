package com.photoshoot.snapbooking.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "portfolios")
public class Portfolio {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;
  private String description;
  private String imageUrl;

  @ManyToOne
  @JoinColumn(name = "photographer_id")
  private User photographer;

  // Getters and Setters
}

