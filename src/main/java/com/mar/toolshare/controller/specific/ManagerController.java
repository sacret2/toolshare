package com.mar.toolshare.controller.specific;

import com.mar.toolshare.controller.BaseController;
import com.mar.toolshare.databases.dao.ItemRepository;
import com.mar.toolshare.databases.dao.PastRentalRepository;
import com.mar.toolshare.databases.dao.RentalRepository;
import com.mar.toolshare.model.entities.Item;
import com.mar.toolshare.model.entities.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/manager")
public class ManagerController extends BaseController {
    @Autowired
    ItemRepository itemRepo;

    @Autowired
    RentalRepository curRentalsRepo;

    @Autowired
    PastRentalRepository pastRentalsRepo;

    // ===== View
    @GetMapping("")
    public String currentRentsList(Model model){
        boolean loggedIn = addLoggedInAndUserDataToModel(model);
        if(!loggedIn)
            return "redirect:/login";

        return "manager/panel";
    }

    @GetMapping("/items")
    public String pastRentsList(Model model){
        boolean loggedIn = addLoggedInAndUserDataToModel(model);
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
        boolean loggedIn = addLoggedInAndUserDataToModel(model);
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
