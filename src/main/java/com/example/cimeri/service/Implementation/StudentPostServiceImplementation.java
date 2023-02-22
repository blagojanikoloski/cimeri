package com.example.cimeri.service.Implementation;

import com.example.cimeri.model.Post;
import com.example.cimeri.model.StudentPost;
import com.example.cimeri.repository.PostRepository;
import com.example.cimeri.repository.StudentPostRepository;
import com.example.cimeri.repository.StudentRepository;
import com.example.cimeri.service.StudentPostService;

import java.util.ArrayList;
import java.util.List;

public class StudentPostServiceImplementation implements StudentPostService {


    private final PostRepository postRepository;
    private final StudentPostRepository studentPostRepository;

    public StudentPostServiceImplementation(PostRepository postRepository, StudentPostRepository studentPostRepository) {
        this.postRepository = postRepository;
        this.studentPostRepository = studentPostRepository;
    }

    @Override
    public List<StudentPost> filteredPosts() {

        List<StudentPost> filteredstudentposts=new ArrayList<>();


        return filteredstudentposts;
    }
}
