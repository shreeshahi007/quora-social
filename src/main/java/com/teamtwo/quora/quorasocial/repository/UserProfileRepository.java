package com.teamtwo.quora.quorasocial.repository;

import com.teamtwo.quora.quorasocial.entity.ProfileFollower;
import com.teamtwo.quora.quorasocial.entity.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends MongoRepository<UserProfile, String> {
}
