package com.teamtwo.quora.quorasocial.controller;

import com.teamtwo.quora.quorasocial.dto.BusinessProfileResponseDTO;
import com.teamtwo.quora.quorasocial.dto.ProfileFollowerResponseDTO;
import com.teamtwo.quora.quorasocial.dto.UserProfileResponseDTO;
import com.teamtwo.quora.quorasocial.dto.dataobjects.BusinessProfileData;
import com.teamtwo.quora.quorasocial.dto.dataobjects.ProfileFollowerData;
import com.teamtwo.quora.quorasocial.dto.dataobjects.UserProfileData;
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

    @GetMapping(value="/getUserProfileDetails/{userID}")
    public UserProfileResponseDTO getUserProfileDetails  (@PathVariable("userId") String userId){

        Optional<UserProfile> data = userProfileService.findById(userId);
        if (!data.isPresent()) return null;

        UserProfile profile  = data.get();
        return new UserProfileResponseDTO(
                true, "", new UserProfileData(
                profile.getProfilePicUrl(),
                profile.getUserName(),
                profile.getUserScore(),
                profileFollowerService.getFollowersCount(profile.getUserId()),
                profileFollowerService.getFollowingCount(profile.getUserId()),
                profile.getUserDescription(),
                profile.getUserCategory()
        ));
    }

    @PostMapping("/addUserProfile")
    public UserProfile addUserProfile(@RequestBody UserProfile userProfile){
        return userProfileService.save(userProfile);
    }

    @GetMapping(value="/getBusinessProfileDetails/{businessId}")
    public BusinessProfileResponseDTO getBusinessProfileDetails  (@PathVariable("businessId") String businessId){
        Optional<BusinessProfile> data= businessProfileService.findById(businessId);
        if (!data.isPresent()) return null;

        BusinessProfile businessProfile=data.get();
        return new BusinessProfileResponseDTO(
                true,"",new BusinessProfileData(
                        businessProfile.getBusinessEmail(),
                        businessProfile.getBusinessName(),
                       businessProfile.getBusinessDescription(),
                       businessProfile.getBusinessCategory()
        ));
    }
    @PostMapping("/addBusinessProfile")
    public BusinessProfile addBusinessProfile(@RequestBody BusinessProfile businessProfile){
        return businessProfileService.save(businessProfile);
    }
    @GetMapping(value="/getProfileFollowerDetails/{id}")
    public ProfileFollowerResponseDTO getProfileFollowerDetails  (@PathVariable("id") String id){
        Optional<ProfileFollower> data= profileFollowerService.findById(id);

        if (!data.isPresent()) return null;

        ProfileFollower profileFollower=data.get();
        return new ProfileFollowerResponseDTO(
                true,"",new ProfileFollowerData(
                        profileFollower.isModerator(),
                        profileFollower.isApproved()
        ));

    }
    @PostMapping("/addProfileFollower")
    public ProfileFollower addProfileFollower(@RequestBody ProfileFollower profileFollower){
        return profileFollowerService.save(profileFollower);
    }
    @GetMapping(value="/getFollowersCount/{followerId}")
    public Integer getFollowersCount(@PathVariable("followerId") String followerId){
        int followersCount = profileFollowerService.getFollowersCount(followerId);
        return followersCount;
    }
    @GetMapping(value="/getFollowingCount/{userId}")
    public Integer getFollowingCount(@PathVariable("userId") String userId)
    {
        int followingCount=profileFollowerService.getFollowingCount(userId);
        return followingCount;
    }


}


