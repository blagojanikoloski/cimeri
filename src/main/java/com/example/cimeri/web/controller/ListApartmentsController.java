package com.example.cimeri.web.controller;

import com.example.cimeri.model.User;
import com.example.cimeri.repository.ApartmentRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping({"/listneededapartments"})
public class ListApartmentsController {


    private final ApartmentRepository apartmentRepository;

    public ListApartmentsController(ApartmentRepository apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
    }

    @GetMapping
    public String getPage(Model model,HttpSession httpSession) throws IOException {


        String cityname= (String) httpSession.getAttribute("cityname");
        int number_of_roommates= (int) httpSession.getAttribute("number_of_roommates");
        int budget= (int) httpSession.getAttribute("budget");


        httpSession.removeAttribute("cityname");
        httpSession.removeAttribute("number_of_roommates");
        httpSession.removeAttribute("budget");

        List filteredapartments=apartmentRepository.filteredapartments(cityname,number_of_roommates,budget);
        model.addAttribute("filteredapartments",filteredapartments);

        return "listneededapartments";
    }

    @PostMapping
    public String listneededapartments(@RequestParam int number_of_roommates, @RequestParam String cityname, @RequestParam int budget
            , HttpSession httpSession, Model model)
    {

        httpSession.setAttribute("number_of_roommates",number_of_roommates);
        httpSession.setAttribute("cityname",cityname);
        httpSession.setAttribute("budget",budget);

        return "redirect:/listneededapartments";

    }

}

