package com.photoshoot.snapbooking.service;


import com.photoshoot.snapbooking.entity.Booking;
import com.photoshoot.snapbooking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookingService {

  @Autowired
  private BookingRepository bookingRepository;

  public Booking saveBooking(Booking booking) {
    return bookingRepository.save(booking);
  }

  public List<Booking> getBookingsByPhotographerId(Long photographerId) {
    return bookingRepository.findByPhotographerId(photographerId);
  }

  public List<Booking> getBookingsByClientId(Long clientId) {
    return bookingRepository.findByClientId(clientId);
  }
}

