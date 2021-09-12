package ru.dixy.sorting.controllers;


import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.dixy.sorting.model.Units;
import ru.dixy.sorting.sorting.Sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(@ModelAttribute("units") Units units, Model model){
         model.addAttribute("units", new Units());
        return "index";
    }

    @PostMapping("/sort")
    public String Sort(@ModelAttribute("units") Units units, Model model){
        List list = new Sort().sortDesc(units.getArr());
        String result = String.join("\n", list);
        model.addAttribute("result", result);
        System.out.println(result);
        return "index";
    }
}