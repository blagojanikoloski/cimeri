package com.example.cimeri.web.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping({"/homestudent"})
public class HomeStudentController {


    @GetMapping
    public String getPage(Model model, HttpSession httpSession) throws IOException {
        return "homestudent";
    }

}
