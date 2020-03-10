/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amisescalade.web;

import org.amisescalade.controller.IUserController;
import org.amisescalade.entity.User;
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
public class ClimbingCommunitySiteController{
    
    @Autowired
    private IUserController iUserController;
    
    @GetMapping("/")
    public String index(Model model){
        
        model.addAttribute("user2", new User()); // valeur par default
        
        System.out.println("ça marche !!"+iUserController.displayUser(2L).toString());
        
        model.addAttribute("user", iUserController.displayUser(2L).getFirstname());
        
        // session by spring ?
        
        return "login";
    }
    
    @PostMapping("/test")
    public String saveUser (@ModelAttribute("user2") User user) {
        
//        iUserController.signUpByDefault(firstname, lastname, username, password);



System.out.println("le post marche !!" + user.getLastname());
        
        
        return "login";
        
    }
    
}