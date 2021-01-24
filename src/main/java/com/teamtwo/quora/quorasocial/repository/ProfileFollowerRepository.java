package com.teamtwo.quora.quorasocial.repository;

import com.teamtwo.quora.quorasocial.entity.ProfileFollower;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileFollowerRepository extends MongoRepository<ProfileFollower, String> {

    List<ProfileFollower> findByFollowerId(String followerId);

    List<ProfileFollower> findByUserId(String userId);
}
