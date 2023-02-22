package com.example.cimeri.repository;

import com.example.cimeri.model.Apartment;
import com.example.cimeri.model.Building;
import com.example.cimeri.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment,Long> {


    @Query("select Max(apartmentid) from Apartment")
    Long findMaxApartmentID();


    @Query("select u.ime,u.prezime,u.phone_number,u.email_address,a.apartment_size,a.apartment_adress,b.building_adress,p.price,photos.photosurl from Building b,User u, Apartment a,Post p,OwnerPost op, Owner o, Photos photos WHERE u.userid=a.ownerid and op.owner_postid=p.postid and op.ownerid=u.userid and o.ownerid=u.userid and o.ownerid=a.ownerid and b.buildingid=a.buildingid and a.apartmentid=op.apartmentid and photos.postid=p.postid and photos.postid=op.owner_postid and p.number_of_roommates=:number_of_roommates and p.price<=:budget and p.cityname=:cityname")
    List filteredapartments(@Param("cityname")String cityname, @Param("number_of_roommates") int number_of_roommates, @Param("budget") int budget);

    @Query("select u.ime,u.prezime,u.phone_number,u.email_address,a.apartment_size,a.apartment_adress,b.building_adress,p.price,photos.photosurl from Building b,User u, Apartment a,Post p,OwnerPost op, Owner o, Photos photos WHERE u.userid=a.ownerid and op.owner_postid=p.postid and op.ownerid=u.userid and o.ownerid=u.userid and o.ownerid=a.ownerid and b.buildingid=a.buildingid and a.apartmentid=op.apartmentid and photos.postid=p.postid and photos.postid=op.owner_postid")
    List allapartments();
}
