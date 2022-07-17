package com.example.gamelive.controller;


import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/")
public class MainController {

    @Secured({"ADMIN", "USER"})
    @GetMapping("/profile")
    public String getProfile(Principal principal, ModelMap modelMap) {
        modelMap.addAttribute("name", principal.getName());
        return "profile";
    }
}
