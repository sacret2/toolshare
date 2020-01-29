package com.mar.toolshare.controller.specific;

import com.mar.toolshare.controller.BaseController;
import com.mar.toolshare.databases.dao.CurrentRentalsRepository;
import com.mar.toolshare.databases.dao.PastRentalsRepository;
import com.mar.toolshare.model.entities.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    @Autowired
    CurrentRentalsRepository curRentalsRepo;

    @Autowired
    PastRentalsRepository pastRentalsRepo;

    @GetMapping("rentals")
    public String currentRentsList(Model model){
        boolean loggedIn = addLoggedInAndUserDataToModel(model);
        if(!loggedIn)
            return "redirect:/login";

        List<Rental> currentRentals = curRentalsRepo.findAllByUserAccount(getLoggedInUserAccount());
        model.addAttribute("rentals", currentRentals);
        return "user/rentals";
    }

    @GetMapping("pastrentals")
    public String pastRentsList(Model model){
        boolean loggedIn = addLoggedInAndUserDataToModel(model);
        if(!loggedIn)
            return "redirect:/login";

        List<Rental> pastRentals = pastRentalsRepo.findAllByUserAccount(getLoggedInUserAccount());
        model.addAttribute("rentals", pastRentals);
        return "user/pastrentals";
    }
    // ===== View end


}
