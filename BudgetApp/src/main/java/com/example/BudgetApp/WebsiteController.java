package com.example.BudgetApp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebsiteController {


    @RequestMapping("/showForm")
    public String showForm() {
        return "index";
    }




}
