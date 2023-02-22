package com.example.cimeri.service.Implementation;

import com.example.cimeri.model.Faculty;
import com.example.cimeri.repository.FacultyRepository;
import com.example.cimeri.service.FacultyService;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FacultyServiceImplementation implements FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyServiceImplementation(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }


    @Override
    public List<Faculty> listAll() { return facultyRepository.findAll();}



}
