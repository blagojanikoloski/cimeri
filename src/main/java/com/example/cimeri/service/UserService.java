package com.example.cimeri.service;

import com.example.cimeri.model.Faculty;
import com.example.cimeri.model.User;

import java.util.List;

public interface UserService {
    Long findMaxUserID();
    List<User> listAll();
    List<User> filteredUsers(String cityname, int budget, int number_of_roommates,Long currentid);




}
