package com.example.cimeri.service.Implementation;

import com.example.cimeri.model.Faculty;
import com.example.cimeri.model.User;
import com.example.cimeri.repository.UserRepository;
import com.example.cimeri.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;


    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Long findMaxUserID() { return userRepository.findMaxUserID();}

    @Override
    public List<User> listAll() { return userRepository.findAll();}

    @Override
    public List<User> filteredUsers(String cityname, int budget, int number_of_roommates, Long currentid) {
        List<User> users=userRepository.findAllStudentsThatHavePosted(cityname,budget,number_of_roommates,currentid);



        return users;

    }

}
