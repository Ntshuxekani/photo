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
  @JoinColumn(name = "photographer_id") // Foreign key column in the portfolios table
  private User photographer;

  // Getters and Setters

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public User getPhotographer() {
    return photographer;
  }

  public void setPhotographer(User photographer) {
    this.photographer = photographer;
  }
}
