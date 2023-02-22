package com.example.cimeri.service.Implementation;

import com.example.cimeri.model.Owner;
import com.example.cimeri.repository.OwnerRepository;
import com.example.cimeri.repository.StudentRepository;
import com.example.cimeri.service.RegisterOwnerService;
import com.example.cimeri.service.RegisterStudentService;
import org.springframework.stereotype.Service;

@Service
public class RegisterOwnerServiceImplementation implements RegisterOwnerService {

    private final OwnerRepository ownerRepository;

    public RegisterOwnerServiceImplementation(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository ;
    }


    @Override
    public Owner register(Long ownerid) {

        Owner owner=null;
        owner=new Owner(ownerid);
        return this.ownerRepository.save(owner);
    }



}
