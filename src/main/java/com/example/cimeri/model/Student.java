package com.example.cimeri.model;

import jakarta.persistence.*;
import lombok.Data;

import javax.lang.model.util.SimpleElementVisitor6;

@Data
@Entity
@Table(name = "student", schema = "project")
public class Student {
    @Id
    private Long studentid;
    private Long facultyid;
    private String gender;

    public Student() {
    }

    public Student(Long studentid, Long facultyid, String gender) {
        this.studentid=studentid;
        this.facultyid=facultyid;
        this.gender=gender;
    }
}
