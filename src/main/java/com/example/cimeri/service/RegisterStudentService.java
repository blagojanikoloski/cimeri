package com.example.cimeri.service;

import com.example.cimeri.model.Student;
import com.example.cimeri.model.User;

public interface RegisterStudentService {

    Student register(Long studentid, Long facultyid, String gender);



}
