package com.example.cimeri.service.Implementation;

import com.example.cimeri.model.Apartment;
import com.example.cimeri.model.Building;
import com.example.cimeri.model.City;
import com.example.cimeri.repository.ApartmentRepository;
import com.example.cimeri.repository.BuildingRepository;
import com.example.cimeri.service.ApartmentService;
import com.example.cimeri.service.BuildingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartmentServiceImplementation implements ApartmentService {

    private final ApartmentRepository apartmentRepository;

    public ApartmentServiceImplementation(ApartmentRepository apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
    }


    @Override
    public Long findMaxApartmentID() { return apartmentRepository.findMaxApartmentID();}

    @Override
    public List<Apartment> listAll() { return apartmentRepository.findAll();}
}
