package com.example.cimeri.service.Implementation;

import com.example.cimeri.model.User;
import com.example.cimeri.model.exceptions.*;
import com.example.cimeri.repository.UserRepository;
import com.example.cimeri.service.AuthenticationService;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class AuthenticationServiceImplementation implements AuthenticationService {

    private final UserRepository userRepository;

    public AuthenticationServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User register(String email_address, String username, String password, String ime, String prezime, String phone_number) {
        if(email_address==null || email_address.isEmpty() || username==null || username.isEmpty() || password==null || password.isEmpty() )
        {
            throw new InvalidArgumentsException();
        }
        User user=null;
        if(!emailIsValid(email_address))
            throw new InvalidEmailException();

        if(this.userRepository.findByUsername(username).isPresent())
            throw new UserAlreadyExistsException(username);


        user=new User(email_address,username,password,ime,prezime,phone_number);
        return this.userRepository.save(user);
    }

    @Override
    public User login(String username, String password) {

        if(username==null || username.isEmpty() || password==null || password.isEmpty())
        {
            throw new InvalidArgumentsException();
        }
        return this.userRepository.findByUsernameAndPassword(username,password).orElseThrow(InvalidCredentialsException::new);
    }

    public static boolean emailIsValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
}
