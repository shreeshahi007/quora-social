package com.teamtwo.quora.quorasocial.service;

import com.teamtwo.quora.quorasocial.entity.ProfileFollower;
import com.teamtwo.quora.quorasocial.repository.ProfileFollowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileFollowerServiceImpl {
    @Autowired
    ProfileFollowerRepository profileFollowerRepository;


    public Optional<ProfileFollower> findById(String id) {
        return profileFollowerRepository.findById(id);
    }

    public ProfileFollower save(ProfileFollower profileFollower) {
        return profileFollowerRepository.save(profileFollower);
    }
}
