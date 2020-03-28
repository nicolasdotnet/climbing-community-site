/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amisescalade.controller;

import org.amisescalade.entity.User;
import org.amisescalade.web.ClimbingCommunitySiteController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author nicolasdotnet
 */
@Controller
public class indexController {
    
    @Autowired
    private UserControllerImpl userController;
    
    private final Logger log = LogManager.getLogger(ClimbingCommunitySiteController.class);
    
     @GetMapping("/")
    public String index(Model model) {
        log.debug("index()");
        return "redirect:/tests";
    }

    @GetMapping("/tests")
    public String tests(Model model) {

        model.addAttribute("user2", new User()); // valeur par default

        System.out.println("ça marche !!" + userController.displayUser(2L).toString());

        model.addAttribute("user", userController.displayUser(2L).getFirstname());

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
    
}
