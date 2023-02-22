package com.example.cimeri.repository;

import com.example.cimeri.model.OwnerPost;
import com.example.cimeri.model.Post;
import com.example.cimeri.model.StudentPost;
import com.example.cimeri.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OwnerPostRepository extends JpaRepository<OwnerPost,Long> {

    @Query("select Max(owner_postid) from OwnerPost")
    Long findMaxOwnerPostID();

}
