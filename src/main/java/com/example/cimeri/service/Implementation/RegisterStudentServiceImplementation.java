package com.example.cimeri.service.Implementation;

import com.example.cimeri.model.Student;
import com.example.cimeri.model.User;
import com.example.cimeri.model.exceptions.*;
import com.example.cimeri.repository.StudentRepository;
import com.example.cimeri.repository.UserRepository;
import com.example.cimeri.service.AuthenticationService;
import com.example.cimeri.service.RegisterStudentService;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class RegisterStudentServiceImplementation implements RegisterStudentService {

    private final StudentRepository studentRepository;

    public RegisterStudentServiceImplementation(StudentRepository studentRepository) {
        this.studentRepository = studentRepository ;
    }


    @Override
    public Student register(Long studentid, Long facultyid, String gender) {

        Student student=null;
        student=new Student(studentid,facultyid,gender);
        return this.studentRepository.save(student);
    }



}
