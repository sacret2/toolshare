package com.mar.toolshare.controller.specific;

import com.mar.toolshare.controller.BaseController;
import com.mar.toolshare.databases.dao.ItemRepository;
import com.mar.toolshare.databases.dao.PastRentalRepository;
import com.mar.toolshare.databases.dao.RentalRepository;
import com.mar.toolshare.databases.dto.IUserData;
import com.mar.toolshare.model.entities.Item;
import com.mar.toolshare.model.entities.PastRental;
import com.mar.toolshare.model.entities.Rental;
import com.mar.toolshare.service.authentication.TsUserDetailsService;
import com.mar.toolshare.service.entities.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/manager")
public class ManagerController extends BaseController {
    @Autowired
    ItemRepository itemRepo;

    @Autowired
    RentalRepository curRentalsRepo;

    @Autowired
    PastRentalRepository pastRentalsRepo;

    @Autowired
    TsUserDetailsService userDetailsService;
    // ===== View
    @GetMapping("")
    public String currentRentsList(Model model){
        boolean loggedIn = addLoggedInUserDataToModel(model);
        if(!loggedIn)
            return "redirect:/login";

        return "manager/panel";
    }
    @GetMapping("/item")
    public String item(@RequestParam("id") long itemId, Model model){
        boolean loggedIn = addLoggedInUserDataToModel(model);
        if(!loggedIn)
            return "redirect:/login";

        Item item = itemRepo.findById(itemId).get();
        model.addAttribute("item", item);

        Rental currentRental = curRentalsRepo.findByItem_ItemId(itemId);
        model.addAttribute("currentRental", currentRental);

        List<PastRental> pastRentals = pastRentalsRepo.findAllByItem(itemId);
        model.addAttribute("rentals", pastRentals);

        return "manager/item";
    }
    @GetMapping("/user")
    public String user(@RequestParam("id") long userId, Model model){
        boolean loggedIn = addLoggedInUserDataToModel(model);
        if(!loggedIn)
            return "redirect:/login";

        IUserData userData = userDetailsService.getUserDataByUserId(userId).orElse(null);

        model.addAttribute("user", userData);

        List<Rental> rentals = curRentalsRepo.findByUser_UserId(userId);
        model.addAttribute("rentals", rentals);

        List<PastRental> pastRentals = pastRentalsRepo.findByUser_UserId(userId);
        model.addAttribute("pastRentals", pastRentals);

        return "manager/user";
    }
    @GetMapping("/items")
    public String items(Model model){
        boolean loggedIn = addLoggedInUserDataToModel(model);
        if(!loggedIn)
            return "redirect:/login";

        Iterable<Item> items = itemRepo.findAll();
        model.addAttribute("items", items);
        return "manager/items";
    }
    // ===== View end

    // ===== Forms
    @GetMapping("/addItem")  // I guess it will generate QR image to print and stick on the item
    public String qrScanView(Model model){
        boolean loggedIn = addLoggedInUserDataToModel(model);
        if(!loggedIn)
            return "redirect:/login";

        model.addAttribute("item", new Item());

        return "manager/addItem";
    }
    // ===== Forms end

    // ===== CRUD
    @PostMapping(value = "/saveItem")
    public String saveItem(Item item) {
        itemRepo.save(item);
        return "redirect:/manager/items";
    }

    @GetMapping("/delete")
    public String removeItem(@RequestParam("id") Long id){
        itemRepo.deleteById(id);
        return "redirect:/manager/items";
    }
    // ===== CRUD end
}
