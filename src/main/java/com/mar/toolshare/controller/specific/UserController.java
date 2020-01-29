package com.mar.toolshare.controller.specific;

import com.mar.toolshare.controller.BaseController;
import com.mar.toolshare.databases.dao.RentalRepository;
import com.mar.toolshare.databases.dao.PastRentalRepository;
import com.mar.toolshare.model.entities.Item;
import com.mar.toolshare.model.entities.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    @Autowired
    RentalRepository curRentalsRepo;

    @Autowired
    PastRentalRepository pastRentalsRepo;

    // ===== View
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
        model.addAttribute("pastRentals", pastRentals);
        return "user/pastrentals";
    }
    // ===== View end

    // =====
//    @PostMapping(value = "/save")
//    public String mockSaveRental() {
//        Rental rental = new Rental();
//        rental.setItem();
//        proService.save(project);
//        return "redirect:/projects/";
//    }


}
