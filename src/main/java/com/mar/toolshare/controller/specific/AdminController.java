package com.mar.toolshare.controller.specific;


import com.mar.toolshare.controller.BaseController;

import com.mar.toolshare.databases.dto.IUserData;
import com.mar.toolshare.service.entities.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {

    @Autowired
    UserService userService;

    // === view
    @GetMapping("/managers")
    public String pastRentsList(Model model){
        boolean loggedIn = addLoggedInAndUserDataToModel(model);
        if(!loggedIn)
            return "redirect:/login";

        Iterable<IUserData> managers = userService.findManagers();

        model.addAttribute("managers", managers);
        return "admin/managers";
    }
    // === view end

    @GetMapping("/delete")
    public String displayEmployeeList(@RequestParam("id") long userId){
        userService.deleteById(userId);
        return "redirect:/admin/managers";
    }
}
