package com.mar.toolshare.controller.specific;

import com.mar.toolshare.controller.BaseController;
import com.mar.toolshare.databases.dao.ItemRepository;
import com.mar.toolshare.databases.dto.IUserData;
import com.mar.toolshare.model.entities.Item;
import com.mar.toolshare.model.entities.PastRental;
import com.mar.toolshare.model.entities.Rental;
import com.mar.toolshare.service.authentication.TsUserDetailsService;
import com.mar.toolshare.service.entities.ItemService;
import com.mar.toolshare.service.entities.PastRentalService;
import com.mar.toolshare.service.entities.RentalService;
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
    ItemService itemService;
    
    @Autowired
    RentalService curRentalsService;

    @Autowired
    PastRentalService pastRentalsService;

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

        Item item = itemService.findById(itemId);
        model.addAttribute("item", item);

        Rental currentRental = curRentalsService.findByItem_ItemId(itemId);
        model.addAttribute("currentRental", currentRental);

        List<PastRental> pastRentals = pastRentalsService.findAllByItem(itemId);
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

        List<Rental> rentals = curRentalsService.findByUser_UserId(userId);
        model.addAttribute("rentals", rentals);

        List<PastRental> pastRentals = pastRentalsService.findByUser_UserId(userId);
        model.addAttribute("pastRentals", pastRentals);

        return "manager/user";
    }
    @GetMapping("/items")
    public String items(Model model){
        boolean loggedIn = addLoggedInUserDataToModel(model);
        if(!loggedIn)
            return "redirect:/login";

        Iterable<Item> items = itemService.findAll();
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
        itemService.save(item);
        return "redirect:/manager/items";
    }

    @GetMapping("/delete")
    public String removeItem(@RequestParam("id") Long id){
        itemService.deleteById(id);
        return "redirect:/manager/items";
    }
    // ===== CRUD end
}
