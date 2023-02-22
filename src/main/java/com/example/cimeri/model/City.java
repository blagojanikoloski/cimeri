package com.example.cimeri.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "city", schema = "project")
public class City {
    @Id
    private String cityname;

    public City() {
    }

    public City(String cityname) {
        this.cityname=cityname;
    }
}
