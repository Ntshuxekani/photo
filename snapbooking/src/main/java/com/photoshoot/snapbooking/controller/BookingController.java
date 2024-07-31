package com.photoshoot.snapbooking.controller;

import com.photoshoot.snapbooking.entity.Booking;
import com.photoshoot.snapbooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/bookings")
public class BookingController {

  @Autowired
  private BookingService bookingService;

  @PostMapping
  public Booking createBooking(@RequestBody Booking booking) {
    return bookingService.saveBooking(booking);
  }

  @GetMapping("/photographer/{photographerId}")
  public List<Booking> getBookingsByPhotographerId(@PathVariable Long photographerId) {
    return bookingService.getBookingsByPhotographerId(photographerId);
  }

  @GetMapping("/client/{clientId}")
  public List<Booking> getBookingsByClientId(@PathVariable Long clientId) {
    return bookingService.getBookingsByClientId(clientId);
  }
}

