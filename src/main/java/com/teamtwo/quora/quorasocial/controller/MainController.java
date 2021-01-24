package com.teamtwo.quora.quorasocial.controller;

import com.teamtwo.quora.quorasocial.entity.BusinessProfile;
import com.teamtwo.quora.quorasocial.entity.ProfileFollower;
import com.teamtwo.quora.quorasocial.entity.UserProfile;
import com.teamtwo.quora.quorasocial.service.BusinessProfileServiceImpl;
import com.teamtwo.quora.quorasocial.service.ProfileFollowerServiceImpl;
import com.teamtwo.quora.quorasocial.service.UserProfileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value="/profile")
public class MainController {

    @Autowired
    UserProfileServiceImpl userProfileService;

    @Autowired
    BusinessProfileServiceImpl businessProfileService;

    @Autowired
    ProfileFollowerServiceImpl profileFollowerService;

    @GetMapping(value="/getUserProfileDetails/{'userID'}")
    public Optional<UserProfile> getUserProfileDetails  (@PathVariable("userId") String userId){
        //businessProfileService.findById("adhasjbdj");
        return userProfileService.findById(userId);
    }

    @PostMapping("/addUserProfile")
    public UserProfile addUserProfile(@RequestBody UserProfile userProfile){
        return userProfileService.save(userProfile);
    }

    @GetMapping(value="/getBusinessProfileDetails/{'businessId'}")
    public Optional<BusinessProfile> getBusinessProfileDetails  (@PathVariable("businessId") String businessId){
        return businessProfileService.findById(businessId);
    }
    @PostMapping("/addBusinessProfile")
    public BusinessProfile addBusinessProfile(@RequestBody BusinessProfile businessProfile){
        return businessProfileService.save(businessProfile);
    }
    @GetMapping(value="/getProfileFollowerDetails/{'id'}")
    public Optional<ProfileFollower> getProfileFollowerDetails  (@PathVariable("id") String id){
        return profileFollowerService.findById(id);
    }
    @PostMapping("/addProfileFollower")
    public ProfileFollower addProfileFollower(@RequestBody ProfileFollower profileFollower){
        return profileFollowerService.save(profileFollower);
    }


    }


