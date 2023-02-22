package com.example.cimeri.service.Implementation;

import com.example.cimeri.model.Faculty;
import com.example.cimeri.repository.PostRepository;
import com.example.cimeri.repository.UserRepository;
import com.example.cimeri.service.PostService;
import com.example.cimeri.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImplementation implements PostService {

    private final PostRepository postRepository;


    public PostServiceImplementation(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Long findMaxPostID() { return postRepository.findMaxPostID();}
}
