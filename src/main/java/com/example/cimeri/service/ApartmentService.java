package com.example.cimeri.service;

import com.example.cimeri.model.Apartment;
import com.example.cimeri.model.Building;
import com.example.cimeri.model.City;
import com.example.cimeri.model.Faculty;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ApartmentService {

    List<Apartment> listAll();
    Long findMaxApartmentID();


}

