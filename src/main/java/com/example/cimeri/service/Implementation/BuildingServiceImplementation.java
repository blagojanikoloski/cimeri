package com.example.cimeri.service.Implementation;

import com.example.cimeri.model.Building;
import com.example.cimeri.model.City;
import com.example.cimeri.repository.BuildingRepository;
import com.example.cimeri.service.BuildingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingServiceImplementation implements BuildingService {

    private final BuildingRepository buildingRepository;

    public BuildingServiceImplementation(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    @Override
    public Long findMaxBuildingID() { return buildingRepository.findMaxBuildingID();}

    @Override
    public List<Building> listAll() { return buildingRepository.findAll();}
}
