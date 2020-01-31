package com.mar.toolshare.controller.specific;

import com.mar.toolshare.controller.BaseController;
import com.mar.toolshare.databases.dao.RentalRepository;
import com.mar.toolshare.databases.dao.PastRentalRepository;
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
    RentalRepository curRentalsRepo;

    @Autowired
    PastRentalRepository pastRentalsRepo;

    // ===== View
    @GetMapping("rentals")
    public String currentRentsList(Model model){
        boolean loggedIn = addLoggedInUserDataToModel(model);
        if(!loggedIn)
            return "redirect:/login";

        List<Rental> currentRentals = curRentalsRepo.findAllByUserAccount(getLoggedInUserAccount());
        model.addAttribute("rentals", currentRentals);
        return "user/rentals";
    }

    @GetMapping("pastRentals")
    public String pastRentsList(Model model){
        boolean loggedIn = addLoggedInUserDataToModel(model);
        if(!loggedIn)
            return "redirect:/login";

        List<Rental> pastRentals = pastRentalsRepo.findAllByUserAccount(getLoggedInUserAccount());
        model.addAttribute("pastRentals", pastRentals);
        return "user/pastrentals";
    }

    @GetMapping("scan")
    public String qrScanView(Model model){
        boolean loggedIn = addLoggedInUserDataToModel(model);
        if(!loggedIn)
            return "redirect:/login";

        model.addAttribute("qrInt", 0);
        return "user/scan";
    }
    // ===== View end

    // =====
//    @PostMapping(value = "/qrscan")
//    public String qrScanMock() {
//        Rental rental = new Rental();
//        rental.setItem();
//        proService.save(project);
//        return "redirect:/projects/";
//    }


}
