package com.teamtwo.quora.quorasocial.service;

import com.teamtwo.quora.quorasocial.entity.UserProfile;
import com.teamtwo.quora.quorasocial.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserProfileServiceImpl {
    @Autowired
    UserProfileRepository userProfileRepository;

    public Optional<UserProfile> findById(String userId) {
        return userProfileRepository.findById(userId);
    }

    public UserProfile save(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }
}
