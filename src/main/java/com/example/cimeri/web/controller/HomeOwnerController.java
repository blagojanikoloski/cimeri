package com.example.cimeri.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping({"/homeowner"})
public class HomeOwnerController {


    @GetMapping
    public String getPage(Model model) throws IOException {
        return "homeowner";
    }

}
