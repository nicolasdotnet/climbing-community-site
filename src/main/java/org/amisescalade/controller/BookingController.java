/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amisescalade.controller;

import java.util.List;
import java.util.logging.Level;
import org.amisescalade.entity.Booking;
import org.amisescalade.entity.Topo;
import org.amisescalade.entity.User;
import org.amisescalade.services.IBookingService;
import org.amisescalade.services.ITopoService;
import org.amisescalade.services.IUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author nicolasdotnet
 */
@Controller
@Transactional
public class BookingController {

    private final Logger log = LogManager.getLogger(BookingController.class);

    @Autowired
    private IBookingService iBookingService;

    @Autowired
    private ITopoService iTopoService;

    @Autowired
    private IUserService iUserService;

    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    // save booking with topo
    @PostMapping("/topo/{id}/booking")
    public String saveBookingTopo(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {

        User user = null;

        try {
            // author par défault

            user = iUserService.getUser(2L);
        } catch (Exception e) {
            
            this.errorMessage = e.getMessage();
        }

        Topo topoFind = null;

        try {
            topoFind = iTopoService.getTopo(Long.valueOf(id));

        } catch (Exception e) {
            
            redirectAttributes.addFlashAttribute("error", e.getMessage());

            return "redirect:/topo/" + id;
            
        }

        if (!topoFind.getTopoStatus()) {

            redirectAttributes.addFlashAttribute("error", "Not Full succès ! ");

            return "topo/list";
        }

        Booking bookingNew = null;
        try {
            bookingNew = iBookingService.register(user, topoFind);

        } catch (Exception e) {

            redirectAttributes.addFlashAttribute("error", e.getMessage());

            return "redirect:/topo/" + id;
        }

        redirectAttributes.addFlashAttribute("msg", "Full succès ! ");

        return "redirect:/booking/" + Math.toIntExact(bookingNew.getBookingId());

    }

    // show booking
    @GetMapping("/booking/{id}")
    public String showBooking(@PathVariable("id") Long id, Model model) {

        log.debug("showBooking() id: {}", id);

        System.out.println("showBooking() id: {}" + id);

        Booking bookingFind = null;

        try {

            bookingFind = iBookingService.getBooking(id);

        } catch (Exception e) {

            this.errorMessage = e.getMessage();
        }

        model.addAttribute("bookingFind", bookingFind);

        System.out.println("bookingSpot() id: {}" + bookingFind.getBookingTopo().getTopoTitle());

        return "/booking/show";

    }

    // booking list page by owner ask
    @GetMapping("/bookings/user")
    public String showAllBookingByUser(Model model, final RedirectAttributes redirectAttributes) {

        log.debug("showAllBookingsbyUser()");

        User userFind = null;
        List<Booking> bookingList = null;

        try {
            userFind = iUserService.getUser(2L);
        } catch (Exception e) {

            this.errorMessage = e.getMessage();
        }

        try {
            bookingList = iBookingService.getAllBookingByUser(userFind);

        } catch (Exception e) {

            this.errorMessage = e.getMessage();
        }

        System.out.println("le post marche !! sector");

        model.addAttribute("bookings", bookingList);

        return "/booking/list";

    }

    // booking list page by owner topo
    @GetMapping("/bookings/topo")
    public String showAllBookingByOwnerTopo(Model model, final RedirectAttributes redirectAttributes) {
        
        
        log.debug("showAllBookingsbyOwnerTopo()");

        User userFind = null;
        List<Booking> bookingList = null;

        try {
            userFind = iUserService.getUser(2L);
        } catch (Exception e) {

            this.errorMessage = e.getMessage();
        }

//        try {
//            bookingList = iBookingService.getAllBookingByOwnertopo(userFind);
//
//        } catch (Exception e) {
//
//            this.errorMessage = e.getMessage();
//        }

        System.out.println("le post marche !! sector");

        model.addAttribute("bookings", bookingList);

        return "/booking/list";

    }

    // validate booking 
    @PostMapping("/booking/{id}/validate")
    public String validateBookingTopo(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {

        Booking bookingFind = null;
        try {
            bookingFind = iBookingService.getBooking(Long.valueOf(id));

        } catch (Exception e) {

            this.errorMessage = e.getMessage();
        }

        Booking bookingNew = null;

        try {
            bookingNew = iBookingService.validate(bookingFind);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(BookingController.class.getName()).log(Level.SEVERE, null, ex);
        }

        redirectAttributes.addFlashAttribute("msg", "Full succès ! ");

        return "redirect:/booking/" + Math.toIntExact(bookingNew.getBookingId());

    }

    // avalidate booking 
    @PostMapping("/booking/{id}/available")
    public String makeAvailableBookingTopo(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {

        Booking bookingFind = null;
        try {
            bookingFind = iBookingService.getBooking(Long.valueOf(id));

        } catch (Exception e) {

            this.errorMessage = e.getMessage();
        }

        Booking bookingNew = null;

        try {
            bookingNew = iBookingService.makeAvailable(bookingFind);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(BookingController.class.getName()).log(Level.SEVERE, null, ex);
        }

        redirectAttributes.addFlashAttribute("msg", "Full succès ! ");

        return "redirect:/booking/" + Math.toIntExact(bookingNew.getBookingId());

    }

    //cancel booking
    @PostMapping("/booking/{id}/cancel")
    public String cancelBooking(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {

        log.debug("deleteBooking() id: {}", id);

        System.out.println("deleteBooking() id: {}" + id);

        Booking bookingFind = null;
        try {
            bookingFind = iBookingService.getBooking(Long.valueOf(id));

        } catch (Exception e) {

            this.errorMessage = e.getMessage();
        }

        Long userId = bookingFind.getBookingUser().getUserId();

        iBookingService.delete(Long.valueOf(id));

        redirectAttributes.addFlashAttribute("msg", "delete");

        return "redirect:/bookings/user";

    }

}
