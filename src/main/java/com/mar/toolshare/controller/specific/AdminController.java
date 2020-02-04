package com.mar.toolshare.controller.specific;


import com.mar.toolshare.controller.BaseController;

import com.mar.toolshare.databases.dto.IUserData;
import com.mar.toolshare.model.entities.UserAccount;
import com.mar.toolshare.service.entities.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {

    @Autowired
    BCryptPasswordEncoder bCryptEncoder;

    @Autowired
    UserService userService;

    // === view
    @GetMapping("/managers")
    public String pastRentsList(Model model){
        boolean loggedIn = addLoggedInUserDataToModel(model);
        if(!loggedIn)
            return "redirect:/login";

        Iterable<IUserData> managers = userService.findManagers();

        model.addAttribute("managers", managers);
        return "admin/managers";
    }
    // === view end

    // === forms
    @GetMapping("/addManager")
    public String qrScanView(Model model){
        boolean loggedIn = addLoggedInUserDataToModel(model);
        if(!loggedIn)
            return "redirect:/login";

        UserAccount manager = new UserAccount();

        model.addAttribute("manager", manager);

        return "admin/addManager";
    }
    // === forms end

    // === CRUD
    @GetMapping("/delete")
    public String deleteManager(@RequestParam("id") long userId){
        userService.deleteById(userId);
        return "redirect:/admin/managers";
    }

    @PostMapping("/save")
    public String saveManager(UserAccount manager){
        manager.setRoles("ROLE_MANAGER");
        manager.setEnabled(true);
        manager.setPassword(bCryptEncoder.encode(manager.getPassword()));
        userService.save(manager);
        return "redirect:/admin/managers";
    }
    // === CRUD end
}
