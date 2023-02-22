package com.example.cimeri.repository;

import com.example.cimeri.model.Building;
import com.example.cimeri.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BuildingRepository extends JpaRepository<Building,Long> {


    @Query("select Max(buildingid) from Building")
    Long findMaxBuildingID();
}
