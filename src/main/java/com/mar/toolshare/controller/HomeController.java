package com.mar.toolshare.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
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
        boolean loggedIn = addLoggedInAndUserDataToModel(model);

        if(loggedIn)
            return "main/home";
        else
            return "redirect:/login";
    }
}
