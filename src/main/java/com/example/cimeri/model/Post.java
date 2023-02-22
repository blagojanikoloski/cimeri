package com.example.cimeri.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "post", schema = "project")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postid;
    private String cityname;
    private int number_of_roommates;
    private int price;
    private LocalDateTime date_posted;
    private String description;


    public Post() {
    }

    public Post(String cityname, int number_of_roommates, int price, LocalDateTime date_posted, String description) {
        this.cityname=cityname;
        this.number_of_roommates=number_of_roommates;
        this.price=price;
        this.date_posted=date_posted;
        this.description=description;
    }
}
