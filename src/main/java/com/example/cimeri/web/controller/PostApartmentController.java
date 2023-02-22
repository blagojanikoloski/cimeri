package com.example.cimeri.web.controller;

import com.example.cimeri.model.*;
import com.example.cimeri.repository.*;
import com.example.cimeri.service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.time.LocalDateTime;

@Controller
@RequestMapping({"/postapartment"})
public class PostApartmentController {


    private final CityService cityService;
    private final PostRepository postRepository;
    private final BuildingRepository buildingRepository;
    private final ApartmentRepository apartmentRepository;
    private final OwnerPostRepository ownerPostRepository;
    private final PhotosRepository photosRepository;


    public PostApartmentController(CityService cityService, PostRepository postRepository, BuildingRepository buildingRepository, ApartmentRepository apartmentRepository, OwnerPostRepository ownerPostRepository, PhotosRepository photosRepository) {
        this.cityService = cityService;
        this.postRepository = postRepository;
        this.buildingRepository = buildingRepository;
        this.apartmentRepository = apartmentRepository;

        this.ownerPostRepository = ownerPostRepository;
        this.photosRepository = photosRepository;
    }

    @GetMapping
    public String getPage(Model model) throws IOException {
        model.addAttribute("cities",cityService.listAll());
        return "postapartment";
    }


    @PostMapping(value = "/createpost")
    public String createpost(@RequestParam int number_of_roommates, @RequestParam String cityname, @RequestParam int price
            , HttpSession httpSession, @RequestParam String building_adress, @RequestParam String apartment_adress, @RequestParam int apartment_size,
                             @RequestParam String photosurl, Model model)
    {
        Post post=new Post(cityname,number_of_roommates,price, LocalDateTime.now(), "izdavam stan");
        postRepository.save(post);
        Long maxPostID=postRepository.findMaxPostID();
        User user = (User)httpSession.getAttribute("user");
        Long ownerID=user.getUserid();
        httpSession.setAttribute("currentid",ownerID);

        Building building=new Building(cityname,building_adress);
        buildingRepository.save(building);
        Long maxBuildingID=buildingRepository.findMaxBuildingID();
        Apartment apartment=new Apartment(maxBuildingID,ownerID,apartment_adress,apartment_size);
        apartmentRepository.save(apartment);
        Long maxApartmentID=apartmentRepository.findMaxApartmentID();

        OwnerPost ownerPost=new OwnerPost(maxPostID,maxApartmentID,ownerID);
        ownerPostRepository.save(ownerPost);

        Long maxOwnerPostID=ownerPostRepository.findMaxOwnerPostID();
        Photos photos=new Photos(maxOwnerPostID,photosurl);
        photosRepository.save(photos);
        //do ovde se kreira ownerpost





        return "redirect:/home";

    }

}
