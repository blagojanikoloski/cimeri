package com.example.cimeri.repository;

import com.example.cimeri.model.City;
import com.example.cimeri.model.Photos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PhotosRepository extends JpaRepository<Photos,Long> {



}
