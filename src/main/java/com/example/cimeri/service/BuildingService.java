package com.example.cimeri.service;

import com.example.cimeri.model.Building;
import com.example.cimeri.model.City;
import com.example.cimeri.model.Faculty;

import java.util.List;

public interface BuildingService {

    List<Building> listAll();
    Long findMaxBuildingID();
}

