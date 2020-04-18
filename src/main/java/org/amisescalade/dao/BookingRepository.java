package org.amisescalade.dao;

import java.util.List;
import org.amisescalade.entity.Booking;
import org.amisescalade.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long>{
    
    List<Booking> findByBookingUser(User user);

}
