package com.example.cimeri.web.controller;

import com.example.cimeri.model.User;
import com.example.cimeri.model.exceptions.InvalidArgumentsException;
import com.example.cimeri.model.exceptions.InvalidCredentialsException;
import com.example.cimeri.service.AuthenticationService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
@RequestMapping({"/loginowner"})
public class LoginOwnerController {

    private final AuthenticationService authenticationService;

    public LoginOwnerController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping
    public String getPage(Model model) throws IOException {
        return "loginowner";
    }

    @PostMapping
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session, Model model)
    {
        User user=null;
        try {
            user=authenticationService.login(username,password);
            session.setAttribute("user",user);
            return "redirect:/homeowner";
        }catch (InvalidArgumentsException | InvalidCredentialsException e)
        {
            model.addAttribute("error",true);
            model.addAttribute("errorMsg",e.getMessage());
            return "login";
        }
    }
}

