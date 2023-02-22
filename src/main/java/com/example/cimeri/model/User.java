package com.example.cimeri.model;

import jakarta.persistence.*;
import lombok.Data;

import javax.lang.model.util.SimpleElementVisitor6;

@Data
@Entity
@Table(name = "appuser", schema = "project")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;

    private String email_address;
    private String username;
    private String password;
    private String ime;
    private String prezime;
    private String phone_number;
    public User() {
    }

    public User(String email_address, String username, String password, String ime, String prezime, String phone_number) {
        this.email_address = email_address;
        this.username = username;
        this.password = password;
        this.ime= ime;
        this.prezime=prezime;
        this.phone_number=phone_number;
    }
}
