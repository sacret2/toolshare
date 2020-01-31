package com.mar.toolshare.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController extends BaseController{

    @Value("${version}")
    private String ver;

    @GetMapping("/")
    public String displayHome(Model model) {
        boolean loggedIn = addLoggedInUserDataToModel(model);
        model.addAttribute("loggedIn", loggedIn);
        if(loggedIn)
            return "main/home";
        else
            return "redirect:/login";
    }

    @GetMapping("/termsAndConditions")
    public String displayTerms(Model model) {
        return "main/termsAndConditions";
    }
}
