package com.example.cimeri.repository;

import com.example.cimeri.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByUsernameAndPassword(String username,String password);

    @Query("select Max(userid) from User")
    Long findMaxUserID();



    @Query("select u from User u,Student s,StudentPost sp,Post p WHERE u.userid=s.studentid and u.userid=sp.studentid and sp.student_postid=p.postid and p.number_of_roommates=:number_of_roommates and p.price<=:budget and p.cityname=:cityname and s.studentid!=:currentid")
    List<User> findAllStudentsThatHavePosted(@Param("cityname")String cityname, @Param("number_of_roommates") int number_of_roommates, @Param("budget") int budget, @Param("currentid") Long currentid);


}
