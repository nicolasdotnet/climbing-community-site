/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amisescalade.services;

import java.util.List;
import org.amisescalade.entity.Booking;
import org.amisescalade.entity.Topo;
import org.amisescalade.entity.User;

/**
 *
 * @author nicolasdotnet
 */
public interface IBookingService {
    
    Booking register (User bookingUser, Topo bookingTopo)throws Exception;
    
    Booking validate(Booking booking) throws Exception;
    
    Booking makeAvailable (Booking booking) throws Exception;
    
    Booking getBooking(Long bookingId) throws Exception;
    
    public List<Booking> getAllBookingByUser(User user) throws Exception;
    
    void delete(Long bookingId);
    
}
