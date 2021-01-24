package com.teamtwo.quora.quorasocial.service;

import com.teamtwo.quora.quorasocial.entity.ProfileFollower;
import com.teamtwo.quora.quorasocial.repository.ProfileFollowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileFollowerServiceImpl {
    @Autowired
    ProfileFollowerRepository profileFollowerRepository;


    public Integer getFollowersCount(String followerId) {
        List<ProfileFollower> profileFollowers = profileFollowerRepository.findByFollowerId(followerId);
        return profileFollowers.size();

    }

    public Optional<ProfileFollower> findById(String id) {
        return profileFollowerRepository.findById(id);
    }

    public ProfileFollower save(ProfileFollower profileFollower) {
        return profileFollowerRepository.save(profileFollower);
    }

    public int getFollowingCount(String userId) {
        List<ProfileFollower> profileFollowers=profileFollowerRepository.findByUserId(userId);
        return profileFollowers.size();
    }
}
