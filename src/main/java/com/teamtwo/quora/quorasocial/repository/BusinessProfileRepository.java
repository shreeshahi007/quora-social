package com.teamtwo.quora.quorasocial.repository;

import com.teamtwo.quora.quorasocial.entity.BusinessProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessProfileRepository extends MongoRepository<BusinessProfile, String> {
}
