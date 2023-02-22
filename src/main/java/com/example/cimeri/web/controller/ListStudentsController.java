package com.example.cimeri.web.controller;

import com.example.cimeri.model.Post;
import com.example.cimeri.model.StudentPost;
import com.example.cimeri.model.User;
import com.example.cimeri.repository.PostRepository;
import com.example.cimeri.repository.StudentPostRepository;
import com.example.cimeri.repository.UserRepository;
import com.example.cimeri.service.FacultyService;
import com.example.cimeri.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping({"/liststudents"})
public class ListStudentsController {


    private final PostRepository postRepository;
    private final StudentPostRepository studentPostRepository;
    private final UserRepository userRepository;
    private final FacultyService facultyService;
    private final UserService userService;

    public ListStudentsController(PostRepository postRepository, StudentPostRepository studentPostRepository, UserRepository userRepository, FacultyService facultyService, UserService userService) {
        this.postRepository = postRepository;
        this.studentPostRepository = studentPostRepository;
        this.userRepository = userRepository;
        this.facultyService = facultyService;
        this.userService = userService;
    }

    @GetMapping
    public String getPage(HttpSession httpSession,Model model) throws IOException {

        String cityname= (String) httpSession.getAttribute("cityname");
        int number_of_roommates= (int) httpSession.getAttribute("number_of_roommates");
        int budget= (int) httpSession.getAttribute("budget");
        Long currentid= (Long) httpSession.getAttribute("currentid");

        httpSession.removeAttribute("cityname");
        httpSession.removeAttribute("number_of_roommates");
        httpSession.removeAttribute("budget");
        httpSession.removeAttribute("currentid");

        List<User> similarusers=userService.filteredUsers(cityname,number_of_roommates,budget,currentid);
        model.addAttribute("similarusers",similarusers);
        return "liststudents";
    }


    @PostMapping(value = "/createpost")
    public String createpost(@RequestParam int number_of_roommates, @RequestParam String cityname, @RequestParam int budget
            , HttpSession httpSession, Model model)
    {
            Post post=new Post(cityname,number_of_roommates,budget, LocalDateTime.now(), "baram cimeri");
            postRepository.save(post);
            Long maxPostID=postRepository.findMaxPostID();
            User user = (User)httpSession.getAttribute("user");
            Long studentID=user.getUserid();
            httpSession.setAttribute("currentid",studentID);
            StudentPost studentPost=new StudentPost(maxPostID,studentID);
            studentPostRepository.save(studentPost);
            //do ovde se kreira studentpost

            httpSession.setAttribute("number_of_roommates",number_of_roommates);
            httpSession.setAttribute("cityname",cityname);
            httpSession.setAttribute("budget",budget);




            return "redirect:/liststudents";

    }

}
