/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amisescalade.controller;

import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

    // confirmation
    @GetMapping("/confirmation")
    public String confirmation() {
        return "/common/infos";

    }

    // information
    @GetMapping("/infos")
    public String information() {
        return "/common/infos";

    }

    @PostMapping("/rate")
    public String rateHandler(HttpServletRequest request) {
        //your controller code
        String referer = request.getHeader("Referer");
        System.out.println("org.amisescalade.controller.indexController.rateHandler() : " + referer);
        return "redirect:" + referer;
    }
}
