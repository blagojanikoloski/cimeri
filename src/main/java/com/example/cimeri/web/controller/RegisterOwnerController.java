package com.example.cimeri.web.controller;

import com.example.cimeri.model.Owner;
import com.example.cimeri.model.Student;
import com.example.cimeri.model.User;

import com.example.cimeri.model.exceptions.UserAlreadyExistsException;
import com.example.cimeri.repository.FacultyRepository;
import com.example.cimeri.repository.StudentRepository;
import com.example.cimeri.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
@RequestMapping({"/registerowner"})
public class RegisterOwnerController {


    private final AuthenticationService authenticationService;
    private final RegisterOwnerService registerOwnerService;
    private final UserService userService;

    public RegisterOwnerController(AuthenticationService authenticationService,  RegisterOwnerService registerStudentService, UserService userService) {
        this.authenticationService = authenticationService;


        this.registerOwnerService = registerStudentService;

        this.userService = userService;
    }


    @GetMapping
    public String getPage(Model model) throws IOException {
        return "registerowner";
    }


    @PostMapping
    public String register(@RequestParam String email_address, @RequestParam String username,
                           @RequestParam String password,@RequestParam String ime,@RequestParam String prezime
            ,@RequestParam String phone_number, Model model)
    {
        Owner owner=null;

        User user=null;
        try{
            user=this.authenticationService.register(email_address,username,password,ime,prezime,phone_number);
            Long maxID=userService.findMaxUserID();
            owner=this.registerOwnerService.register(maxID);
            return "redirect:/loginowner";
        }catch (UserAlreadyExistsException e)
        {
            model.addAttribute("error",true);
            return "registerowner";
        }
    }

}