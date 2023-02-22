package com.example.cimeri.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "apartment_photos", schema = "project")
public class Photos {
    @Id
    private Long postid;

    private String photosurl;

    public Photos() {
    }

    public Photos(Long postid,String photosurl) {

        this.postid=postid;
        this.photosurl=photosurl;

    }
}
