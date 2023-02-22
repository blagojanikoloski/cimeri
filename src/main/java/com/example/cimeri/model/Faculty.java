package com.example.cimeri.model;

import jakarta.persistence.*;
import lombok.Data;



@Data
@Entity
@Table(name = "faculty", schema = "project")
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long facultyid;

    private String facultyname;
    private String cityname;

    public Faculty() {
    }

    public Faculty(Long facultyid, String facultyname, String cityname) {
        this.facultyid=facultyid;
        this.facultyname=facultyname;
        this.cityname=cityname;
    }
}
