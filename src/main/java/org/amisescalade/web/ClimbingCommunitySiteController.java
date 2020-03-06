/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amisescalade.web;

import org.amisescalade.controller.IUserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
        
        System.out.println("ça marche !!"+iUserController.displayUser(2L).toString());
        
        model.addAttribute("user", iUserController.displayUser(2L).getFirstname());
        
        // session by spring ?
        
        return "login";
    }
    
    
    
}