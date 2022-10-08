package com.example.BudgetApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller

public class WebsiteController {


    @RequestMapping("/showForm")
    public String showForm() {
        return "test";
    }

    @RequestMapping("/processForm")
    public String processForm() {
        return "budgetapp";
    }


}
