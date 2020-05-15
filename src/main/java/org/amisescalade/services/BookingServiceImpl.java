/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amisescalade.services;

import org.amisescalade.services.interfaces.ITopoService;
import org.amisescalade.services.interfaces.IBookingService;
import org.amisescalade.services.interfaces.IUserService;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.amisescalade.dao.BookingRepository;
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
    private IUserService iUserService;

    @Autowired
    private ITopoService iTopoService;

    @Override
    public Booking register(String username, Long topoId) throws Exception {

        Optional<User> userFind = iUserService.getUserByUsername(username);

        if (!userFind.isPresent()) {

            log.error("Réservation Impossible ! l'utilisateur " + username + " n'existe pas dans la base.");

            throw new Exception("Réservation Impossible ! l'utilisateur " + username + " n'existe pas ");

        }

        Topo topoFind = iTopoService.getTopo(topoId);

        if (topoFind == null) {

            log.error("Réservation Impossible ! le topo " + topoId + " n'existe pas dans la base.");

            throw new Exception("Réservation Impossible ! le topo " + topoId + " n'existe pas dans la base.");

        } else if (!topoFind.getTopoStatus()) {

            log.error("Réservation Impossible ! le topo " + topoId + " est déjà réservé.");

            throw new Exception("Réservation Impossible ! le topo " + topoId + " est déjà réservé.");
        }

        Booking booking = new Booking();

        booking.setBookingTopo(topoFind);
        booking.setBookingUser(userFind.get());
        booking.setBookingStatus(false);
        booking.setBookingDate(new Date());

        return bookingRepository.save(booking);
    }

    @Override
    public Booking validate(Long bookingId) throws Exception {

        Optional<Booking> bookingFind = bookingRepository.findById(bookingId);

        if (!bookingFind.isPresent()) {

            log.error("Validation Impossible ! le booking " + bookingId + " n'existe pas dans la base.");

            throw new Exception("Validation Impossible ! le booking " + bookingId + " n'existe pas dans la base.");

        }
        bookingFind.get().setBookingStatus(true);
        bookingFind.get().setBookingDate(new Date());

        bookingFind.get().getBookingTopo().setTopoStatus(false);

        return bookingRepository.saveAndFlush(bookingFind.get());

    }

    @Override
    public Booking makeAvailable(Long bookingId) throws Exception {

        Optional<Booking> bookingFind = bookingRepository.findById(bookingId);

        if (!bookingFind.isPresent()) {

            log.error("Invalidation Impossible ! le booking " + bookingId + " n'existe pas dans la base.");

            throw new Exception("Invalidation Impossible ! le booking " + bookingId + " n'existe pas dans la base.");

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

            log.error("Le booking "  + bookingId +  " n'existe pas dans la base.");
            
            throw new Exception("Le booking " + bookingId + " n'existe pas dans la base.");

        }
        return bookingFind.get();
    }

    @Override
    public List<Booking> getAllBookingByUser(String username) throws Exception {

        Optional<User> userFind = iUserService.getUserByUsername(username);

        return bookingRepository.findByBookingUser(userFind.get());

    }

    @Override
    public void delete(Long bookingId) {

        Booking booking = bookingRepository.getOne(bookingId);

        booking.getBookingTopo().setTopoStatus(true);

        bookingRepository.deleteById(bookingId);
    }

}
