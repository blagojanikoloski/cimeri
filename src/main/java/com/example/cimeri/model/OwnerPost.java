package com.example.cimeri.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "owner_post", schema = "project")
public class OwnerPost {
    @Id
    private Long owner_postid;
    private Long apartmentid;
    private Long ownerid;




    public OwnerPost() {
    }

    public OwnerPost(Long owner_postid,Long apartmentid,Long ownerid) {
        this.owner_postid=owner_postid;
        this.apartmentid=apartmentid;
        this.ownerid=ownerid;

    }
}
