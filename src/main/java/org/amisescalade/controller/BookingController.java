/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amisescalade.controller;

import java.security.Principal;
import java.util.List;
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

    // save booking with topo
    @PostMapping("/user/topo/{id}/booking")
    public String saveBookingTopo(@PathVariable("id") int id, final RedirectAttributes redirectAttributes, Principal principal) {

        log.debug("saveBookingTopo() id: {}", id);

        User user = null;
        Topo topoFind = null;
        Booking bookingNew = null;

        try {

            user = iUserService.getUserByUsername(principal.getName());

            topoFind = iTopoService.getTopo(Long.valueOf(id));

            if (!topoFind.getTopoStatus()) {

                redirectAttributes.addFlashAttribute("error", "Topo déjà réservé");

                return "redirect:/user/topo/" + id;
            }

            bookingNew = iBookingService.register(user, topoFind);

        } catch (Exception e) {

            redirectAttributes.addFlashAttribute("error", e.getMessage());

            return "redirect:/user/topo/" + id;
        }

        redirectAttributes.addFlashAttribute("msg", "Réservation réalisée ");

        return "redirect:/user/booking/" + Math.toIntExact(bookingNew.getBookingId());

    }

    // show booking
    @GetMapping("/user/booking/{id}")
    public String showBooking(@PathVariable("id") Long id, Model model, Principal principal) {

        log.debug("showBooking() id: {}", id);

        Booking bookingFind = null;

        try {

            bookingFind = iBookingService.getBooking(id);

        } catch (Exception e) {

            model.addAttribute("error", e.getMessage());

            return "/user/confirmation";
        }
        
        boolean owner = isOwner(principal.getName(), bookingFind.getBookingUser().getUsername());

        model.addAttribute("bookingFind", bookingFind);
        model.addAttribute("owner", owner);

        return "/booking/show";

    }

    // booking list page by owner ask
    @GetMapping("/user/bookings")
    public String showAllBookingByUser(Model model, Principal principal) {

        log.debug("showAllBookingsbyUser()");

        User userFind = null;
        List<Booking> bookingList = null;

        try {
            userFind = iUserService.getUserByUsername(principal.getName());

            bookingList = iBookingService.getAllBookingByUser(userFind);

        } catch (Exception e) {

            model.addAttribute("error", e.getMessage());
        }

        model.addAttribute("bookings", bookingList);
        model.addAttribute("user", userFind);

        return "/booking/list";

    }

    // validate booking 
    @PostMapping("/user/booking/{id}/validate")
    public String validateBookingTopo(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {

        log.debug("validateBookingTopo id: {}", id);
        
        Booking bookingFind = null;
        Booking bookingNew = null;

        try {
            bookingFind = iBookingService.getBooking(Long.valueOf(id));

            bookingNew = iBookingService.validate(bookingFind);

        } catch (Exception e) {

            redirectAttributes.addFlashAttribute("error", e.getMessage());

            return "redirect:/user/bookings/topos";
        }

        redirectAttributes.addFlashAttribute("msg", "Réservation acceptée ! ");

        return "redirect:/user/booking/" + Math.toIntExact(bookingNew.getBookingId());

    }

    // avalidate booking 
    @PostMapping("/user/booking/{id}/available")
    public String makeAvailableBookingTopo(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {

        log.debug("makeAvailableBookingTopo id: {}", id);
        
        Booking bookingFind = null;
        Booking bookingNew = null;
        
        try {
            bookingFind = iBookingService.getBooking(Long.valueOf(id));
            
            bookingNew = iBookingService.makeAvailable(bookingFind);

        } catch (Exception e) {

            redirectAttributes.addFlashAttribute("error", e.getMessage());

            return "redirect:/user/bookings/topos";
        }

        redirectAttributes.addFlashAttribute("msg", "Réservation refusée ");

        return "redirect:/user/booking/" + Math.toIntExact(bookingNew.getBookingId());

    }

    // cancel booking
    @PostMapping("/user/booking/{id}/cancel")
    public String cancelBooking(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {

        log.debug("deleteBooking() id: {}", id);
        
        try {
            
            iBookingService.delete(Long.valueOf(id));

        } catch (Exception e) {

            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/user/bookings/topos";
        }

        redirectAttributes.addFlashAttribute("msg", "delete");

        return "redirect:/user/bookings";

    }
    
        public boolean isOwner(String username, String userFind) {

        System.out.println(username);

        System.out.println(userFind);

        System.out.println(username.equals(userFind));

        if (username.equals(userFind)) {

            return true;

        }

        return false;

    }

}
