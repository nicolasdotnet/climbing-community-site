/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amisescalade.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author nicolasdotnet
 */
@Controller
public class indexController {
   
    
    private final Logger log = LogManager.getLogger(indexController.class);
    
     @GetMapping("/")
    public String index() {
        log.debug("index()");
        return "index";
    }    
}