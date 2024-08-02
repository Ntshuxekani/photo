package com.photoshoot.snapbooking.repository;

import com.photoshoot.snapbooking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
  List<Booking> findByPhotographerId(Long photographerId);
  List<Booking> findByClientId(Long clientId); // This method will now work
}
