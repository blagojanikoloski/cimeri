package com.example.cimeri.service.Implementation;

import com.example.cimeri.model.City;

import com.example.cimeri.repository.CityRepository;

import com.example.cimeri.service.CityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImplementation implements CityService {

    private final CityRepository cityRepository;

    public CityServiceImplementation(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<City> listAll() { return cityRepository.findAll();}


}
