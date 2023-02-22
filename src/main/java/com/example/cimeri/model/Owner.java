package com.example.cimeri.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "apartment_owner", schema = "project")
public class Owner {
    @Id
    private Long ownerid;


    public Owner() {
    }

    public Owner(Long ownerid) {
        this.ownerid=ownerid;

    }
}
