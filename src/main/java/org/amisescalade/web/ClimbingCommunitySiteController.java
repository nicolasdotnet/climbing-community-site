/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amisescalade.web;

import java.util.List;
import org.amisescalade.controller.ISpotController;
import org.amisescalade.controller.IUserController;
import org.amisescalade.entity.Spot;
import org.amisescalade.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author nicolasdotnet
 */
@Controller
public class ClimbingCommunitySiteController {

    @Autowired
    private IUserController iUserController;

    @Autowired
    private ISpotController iSpotController;

    private final Logger log = LogManager.getLogger(ClimbingCommunitySiteController.class);

    @GetMapping("/")
    public String index(Model model) {
        log.debug("index()");
        return "redirect:/tests";
    }

    @GetMapping("/tests")
    public String tests(Model model) {

        model.addAttribute("user2", new User()); // valeur par default

        System.out.println("ça marche !!" + iUserController.displayUser(2L).toString());

        model.addAttribute("user", iUserController.displayUser(2L).getFirstname());

        // session by spring ?
        return "login";
    }

    @PostMapping("/test")
    public String saveUser(@ModelAttribute("user2") User user) {

//        iUserController.signUpByDefault(firstname, lastname, username, password);
        System.out.println("le post marche !!" + user.getLastname());

        return "login";

    }
        
    
    @GetMapping("/template")
    public String template() {

        return "template";
    }
    
    
    
    
    
    
    
    
    
    
    
    
    

    // spot list page
    @GetMapping("/spots")
    public String showAllspots(Model model) {

        log.debug("showAllspots()");

        List<Spot> spots = iSpotController.displayAllSpots();

        System.out.println("le post marche !! spots");

        model.addAttribute("spots", spots);

        return "spots";
    }

    // spot list page by name
    @GetMapping("/spots/searchSpotByMc")
    public String searchSpotByMc(Model model, @RequestParam("spotName") String spotName) {

        List<Spot> spots = iSpotController.displaySpotByName(spotName);

        System.out.println("le post marche !! searchSpotByMc");

        model.addAttribute("spots", spots);

        return "spots";
    }

    // show add spot form
    @GetMapping("/spots/add")
    public String showAddSpotForm(Model model) {

        log.debug("showAddSpotForm()");
        model.addAttribute("spotForm", new Spot());

        return "spotform";

    }

    // save or update spot
    @PostMapping("/spots")
    public String saveOrUpdateSpot(@ModelAttribute("spotForm") Spot spot, final RedirectAttributes redirectAttributes) {
        
        System.out.println("le post marche !! spotForm : "+spot.getSpotName());

        Spot spotNew = iSpotController.addSpot(spot.getSpotName(), spot.getSpotRate(), spot.getSpotDescription(), spot.getSpotAccessPath(), spot.getDepartement(), spot.getCountry());

        System.out.println("spotForm : id"+ spotNew.getSpotId());
        System.out.println("spotForm : id"+ Math.toIntExact(spotNew.getSpotId()));
        
         redirectAttributes.addFlashAttribute("msg", "Full succès ! ");
        
        return "redirect:/spots/" + Math.toIntExact(spotNew.getSpotId());

//        return "spots";

    }
    
    // show spot
    @GetMapping("/spots/{id}")
    public String showSpot(@PathVariable("id") Long id, Model model) {
        
        log.debug("showSpot() id: {}", id);
        
        System.out.println("showSpot() id: {}"+ id);
        
        Spot spotFind = iSpotController.displaySpot(Long.valueOf(id));
        
        model.addAttribute("spotFind", spotFind);
        
        System.out.println("showSpot() id: {}"+ spotFind.getSpotName());
        
        
        return "show";
        
        
    }
    
     //delette spot
    @PostMapping("/spots/{id}/delete")
    public String deleteSpot (@PathVariable("id") int id, final RedirectAttributes redirectAttributes){
        
        log.debug("deleteSpot() id: {}", id);
        
         System.out.println("deleteSpot() id: {}"+ id);
        
        iSpotController.removeSpot(Long.valueOf(id));
        
        redirectAttributes.addFlashAttribute("msg", "delete");
        
        
        
        return "redirect:/spots";
        
        
    }

}
