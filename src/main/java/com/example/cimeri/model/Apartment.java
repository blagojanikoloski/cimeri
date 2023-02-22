package com.example.cimeri.model;

import jakarta.persistence.*;
import lombok.Data;



@Data
@Entity
@Table(name = "apartment", schema = "project")
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long apartmentid;

    private Long buildingid;
    private Long ownerid;
    private String apartment_adress;
    private int apartment_size;

    public Apartment() {
    }

    public Apartment(Long buildingid, Long ownerid, String apartment_adress, int apartment_size) {
        this.buildingid=buildingid;
        this.ownerid=ownerid;
        this.apartment_adress=apartment_adress;
        this.apartment_size=apartment_size;
    }
}
