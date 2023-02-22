package com.example.cimeri.model;

import jakarta.persistence.*;
import lombok.Data;



@Data
@Entity
@Table(name = "building", schema = "project")
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long buildingid;

    private String cityname;
    private String building_adress;

    public Building() {
    }

    public Building(String cityname, String building_adress) {
        this.cityname=cityname;
        this.building_adress=building_adress;
    }
}
