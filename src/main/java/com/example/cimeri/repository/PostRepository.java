package com.example.cimeri.repository;

import com.example.cimeri.model.Post;
import com.example.cimeri.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {


    @Query("select Max(postid) from Post")
    Long findMaxPostID();

}
