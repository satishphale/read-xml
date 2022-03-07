package com.example.readxml.service;

import com.example.readxml.model.Profile;
import com.example.readxml.repo.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProfileService {

    @Autowired
    ProfileRepo profileRepo;


    public List<Profile> findProfiles()
    {
        return profileRepo.findAll();
    }

    public void addProfile(Profile profile)
    {
        profileRepo.insert(profile);
        return;
    }



}
