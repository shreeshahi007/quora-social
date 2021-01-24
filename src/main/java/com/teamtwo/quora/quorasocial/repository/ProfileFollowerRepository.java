package com.teamtwo.quora.quorasocial.repository;

import com.teamtwo.quora.quorasocial.entity.ProfileFollower;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileFollowerRepository extends MongoRepository<ProfileFollower, String> {
}
