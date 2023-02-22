package com.example.cimeri.web.controller;

import com.example.cimeri.repository.CityRepository;
import com.example.cimeri.service.CityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping({"/findroommates"})
public class FindRoommatesController {


    public final CityRepository cityRepository;
    public final CityService cityService;

    public FindRoommatesController(CityRepository cityRepository, CityService cityService) {
        this.cityRepository = cityRepository;
        this.cityService = cityService;
    }

    @GetMapping
    public String getPage(Model model) throws IOException {


        model.addAttribute("cities",cityService.listAll());
        return "findroommates";
    }

}
