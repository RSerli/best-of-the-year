package com.yearrimander.best_of_the_year.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/")
public class BestOfTheYearController {

    //funzione per ritornare il file HTML
    @GetMapping("/BestOfTheYear")
    public String BestOfTheYear( @RequestParam(required=false) String userFirstName,
                                Model model) {
        model.addAttribute("userFirstName", userFirstName);
        return "BestOfTheYear";
    }
    
}
