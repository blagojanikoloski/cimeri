package com.example.cimeri.service.Implementation;

import com.example.cimeri.model.OwnerPost;
import com.example.cimeri.model.Post;
import com.example.cimeri.model.StudentPost;
import com.example.cimeri.repository.OwnerPostRepository;
import com.example.cimeri.repository.PostRepository;
import com.example.cimeri.repository.StudentPostRepository;
import com.example.cimeri.repository.StudentRepository;
import com.example.cimeri.service.OwnerPostService;
import com.example.cimeri.service.StudentPostService;

import java.util.ArrayList;
import java.util.List;

public class OwnerPostServiceImplementation implements OwnerPostService {


    private final PostRepository postRepository;
    private final OwnerPostRepository ownerPostRepository;

    public OwnerPostServiceImplementation(PostRepository postRepository, OwnerPostRepository ownerPostRepository) {
        this.postRepository = postRepository;
        this.ownerPostRepository = ownerPostRepository;
    }

    @Override
    public Long findMaxOwnerPostID() { return ownerPostRepository.findMaxOwnerPostID();}
}
