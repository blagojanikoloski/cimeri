package com.example.cimeri.service.Implementation;

import com.example.cimeri.model.City;

import com.example.cimeri.model.Photos;
import com.example.cimeri.repository.CityRepository;

import com.example.cimeri.repository.PhotosRepository;
import com.example.cimeri.service.CityService;
import com.example.cimeri.service.PhotosService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotosServiceImplementation implements PhotosService {

    private final PhotosRepository photosRepository;

    public PhotosServiceImplementation(PhotosRepository photosRepository) {
        this.photosRepository = photosRepository;
    }

    @Override
    public List<Photos> listAll() { return photosRepository.findAll();}


}
