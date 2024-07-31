package com.photoshoot.snapbooking.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class Booking {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private LocalDateTime bookingDate;

  @ManyToOne
  @JoinColumn(name = "photographer_id")
  private User photographer;

  @ManyToOne
  @JoinColumn(name = "client_id")
  private User client;

  // Getters and Setters
}

