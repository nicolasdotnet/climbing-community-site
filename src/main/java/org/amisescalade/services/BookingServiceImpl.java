/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amisescalade.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.amisescalade.dao.BookingRepository;
import org.amisescalade.dao.TopoRepository;
import org.amisescalade.entity.Booking;
import org.amisescalade.entity.Topo;
import org.amisescalade.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author nicolasdotnet
 */
@Service
@Transactional
public class BookingServiceImpl implements IBookingService {

    private static final Logger log = LogManager.getLogger(BookingServiceImpl.class);

    @Autowired
    private BookingRepository bookingRepository;
    
    @Autowired
    private TopoRepository topoRepository;

    @Override
    public Booking register(User bookingUser, Topo bookingTopo) throws Exception {

        Booking booking = new Booking();

        booking.setBookingTopo(bookingTopo);
        booking.setBookingUser(bookingUser);
        booking.setBookingStatus(false);
        booking.setBookingDate(new Date());
        

        return bookingRepository.save(booking);
    }

    @Override
    public Booking validate(Booking booking) throws Exception {

        Optional<Booking> bookingFind = bookingRepository.findById(booking.getBookingId());

        if (!bookingFind.isPresent()) {

            log.error("Modification Impossible ! le booking " + booking.getBookingId() + " n'existe pas dans la base.");

            return bookingFind.get();

        }
        bookingFind.get().setBookingStatus(true);
        bookingFind.get().setBookingDate(new Date());

        bookingFind.get().getBookingTopo().setTopoStatus(false);

        return bookingRepository.saveAndFlush(bookingFind.get());

    }

    @Override
    public Booking makeAvailable(Booking booking) throws Exception {

        Optional<Booking> bookingFind = bookingRepository.findById(booking.getBookingId());

        if (!bookingFind.isPresent()) {

            log.error("Modification Impossible ! le booking " + booking.getBookingId() + " n'existe pas dans la base.");

            return bookingFind.get();

        }
        bookingFind.get().setBookingStatus(false);
        bookingFind.get().setBookingDate(new Date());

        bookingFind.get().getBookingTopo().setTopoStatus(true);

        return bookingRepository.saveAndFlush(bookingFind.get());

    }

    @Override
    public Booking getBooking(Long bookingId) throws Exception {

        Optional<Booking> bookingFind = bookingRepository.findById(bookingId);

        if (!bookingFind.isPresent()) {

            log.error("Modification Impossible ! le booking " + bookingFind.get().getBookingId() + " n'existe pas dans la base.");

        }
        return bookingFind.get();
    }

    @Override
    public List<Booking> getAllBookingByUser(User user) throws Exception {
        return bookingRepository.findByBookingUser(user);

    }

    @Override
    public void delete(Long bookingId) {
        
        Booking booking = bookingRepository.getOne(bookingId);
        
        booking.getBookingTopo().setTopoStatus(true);
        
        bookingRepository.deleteById(bookingId);
    }

}
