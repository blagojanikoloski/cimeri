package com.example.cimeri.service;

import com.example.cimeri.model.User;

public interface AuthenticationService {

    User register(String email_address, String username, String password, String ime, String prezime, String phone_number);

    User login(String username,String password);

}
