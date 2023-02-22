package com.example.cimeri.web.controller;

import com.example.cimeri.model.Student;
import com.example.cimeri.model.User;

import com.example.cimeri.model.exceptions.InvalidArgumentsException;
import com.example.cimeri.model.exceptions.InvalidEmailException;
import com.example.cimeri.model.exceptions.UserAlreadyExistsException;
import com.example.cimeri.repository.FacultyRepository;
import com.example.cimeri.repository.StudentRepository;
import com.example.cimeri.service.AuthenticationService;
import com.example.cimeri.service.FacultyService;
import com.example.cimeri.service.RegisterStudentService;
import com.example.cimeri.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
@RequestMapping({"/registerstudent"})
public class RegisterStudentController {


    private final AuthenticationService authenticationService;
    private final FacultyService facultyService;
    private final FacultyRepository facultyRepository;
    private final RegisterStudentService registerStudentService;
    private final StudentRepository studentRepository;
    private final UserService userService;

    public RegisterStudentController(AuthenticationService authenticationService, FacultyService facultyService, FacultyRepository facultyRepository, RegisterStudentService registerStudentService, StudentRepository studentRepository, UserService userService) {
        this.authenticationService = authenticationService;
        this.facultyService = facultyService;
        this.facultyRepository = facultyRepository;
        this.registerStudentService = registerStudentService;
        this.studentRepository = studentRepository;
        this.userService = userService;
    }


    @GetMapping
    public String getPage(Model model) throws IOException {
        model.addAttribute("faculties",facultyService.listAll());
        return "registerstudent";
    }


    @PostMapping
    public String register(@RequestParam String email_address, @RequestParam String username,
                           @RequestParam String password,@RequestParam String ime,@RequestParam String prezime
                            ,@RequestParam String phone_number,@RequestParam Long facultyid,@RequestParam String gender, Model model)
    {
        Student student=null;

        User user=null;
        try{
            user=this.authenticationService.register(email_address,username,password,ime,prezime,phone_number);
            Long maxID=userService.findMaxUserID();
            student=this.registerStudentService.register(maxID,facultyid,gender);
            return "redirect:/loginstudent";
        }catch (UserAlreadyExistsException | InvalidArgumentsException | InvalidEmailException e)
        {
            model.addAttribute("error",true);
            model.addAttribute("errorMsg",e.getMessage());
            return "registerstudent";
        }
    }

}