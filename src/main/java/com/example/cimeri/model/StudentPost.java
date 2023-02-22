package com.example.cimeri.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "student_post", schema = "project")
public class StudentPost {
    @Id
    private Long student_postid;
    private Long studentid;



    public StudentPost() {
    }

    public StudentPost(Long student_postid,Long studentid) {
        this.student_postid=student_postid;
        this.studentid=studentid;

    }
}
