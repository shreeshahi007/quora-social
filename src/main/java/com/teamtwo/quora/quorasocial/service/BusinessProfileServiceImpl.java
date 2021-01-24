package com.teamtwo.quora.quorasocial.service;

import com.teamtwo.quora.quorasocial.entity.BusinessProfile;
import com.teamtwo.quora.quorasocial.repository.BusinessProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BusinessProfileServiceImpl {

    @Autowired
    BusinessProfileRepository businessProfileRepository;

    public Optional<BusinessProfile> findById(String userId) {
        return businessProfileRepository.findById(userId);
    }

    public BusinessProfile save(BusinessProfile businessProfile) {
        return businessProfileRepository.save(businessProfile);
    }
}
