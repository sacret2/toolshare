package com.mar.toolshare.controller;

import com.mar.toolshare.auxiliary.ZXingHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

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

    @GetMapping(value = "/qrcode/{id}")
    public void qrcode(@PathVariable String id, HttpServletResponse response) throws Exception {
        response.setContentType("image/png");
        OutputStream outputStream = response.getOutputStream();
        outputStream.write(ZXingHelper.getQRCodeImage(id, 200, 200));
        outputStream.flush();
        outputStream.close();
    }
}
